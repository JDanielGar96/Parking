package com.unbosque.filters;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.xhtml"})
public class AuthFilter implements Filter {
    
	public static String[] authorizedUrls = {
			"/index.xhtml",
			"/user/login.xhtml",
			"/user/register.xhtml"
	};
	
    public AuthFilter() {}
 
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
         try {
 
            // Check variables on session ( If exist )
        	 
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            
            HttpSession session = req.getSession(false);
            
            //  Filter by type of user
            String requestUrl = req.getRequestURI();
            
            if(session != null && session.getAttribute("userName") != null) {
            	if(this.validateUserAuth(requestUrl, session) || this.validatePublicUrls(requestUrl)) {
            		chain.doFilter(request, response);
            	} else {
            		String userType = (String) session.getAttribute("userType");
            		res.sendRedirect(req.getContextPath() + 
            				"/" + userType.toLowerCase() + "/home.xhtml");
            	}
            } else {
            	if(this.validateUrls(requestUrl) || this.validatePublicUrls(requestUrl)) {
            		chain.doFilter(request, response);
            	} else {
            		res.sendRedirect(req.getContextPath() + "/index.xhtml");
            	}
            }

      }
     catch(Throwable t) {
         System.out.println( t.getMessage());
     }
    }
    
    private boolean validateUrls(String urlName) {
    	// Validate urls of not logged users
    	for(String url: AuthFilter.authorizedUrls) {
    		if(urlName.indexOf(url) >= 0) {
    			return true;
    		}
    	}
    	return false;
    }
    
    private boolean validatePublicUrls(String requestUrl) {
    	// Validate if url is public or not
    	return requestUrl.indexOf("/public/") >= 0 ||
    			requestUrl.contains("javax.faces.resource");
    }
 
    private boolean validateUserAuth(String urlName, HttpSession session) {
    	// Validate users thought avalible authorizations in the db
    	try {    		
    		String levelAuth = (String) session.getAttribute("userType");
    		if(urlName.indexOf("client") >= 0 && levelAuth.equalsIgnoreCase("CLIENT") ||
    				urlName.indexOf("admin") >= 0 && levelAuth.equalsIgnoreCase("ADMIN") ||
    				urlName.indexOf("owner") >= 0 && levelAuth.equalsIgnoreCase("OWNER")) {
    			return true;
    		}
    	} catch (Exception e) {
    		return false;
    	}
    	return false;
    }
    
    @Override
    public void destroy() {}
}