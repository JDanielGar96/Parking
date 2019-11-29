package com.unbosque.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	
	private Properties properties;
	
	public Email() {
		// Cargar propiedades
		ClassLoader classLoader = getClass().getClassLoader();
        try {
        	InputStream input = new FileInputStream(classLoader.getResource("email.properties").getFile());
        	input.read();
            properties = new Properties();
    
            // load a properties file
            properties.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
	
//	public static void main(String[] args) {
//		Email email = new Email();
//		email.sendEmail("Prueba", "Test");
//	}

	public void sendEmail(ArrayList<String> to, String subject, String content_message)
	        throws MessagingException {

	    boolean debug = false;

	    try {
	        String host = "smtp.gmail.com";
	        
	        
	        Properties props = System.getProperties();
	        
	        props.put("mail.smtp.starttls.enable", "true"); 
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.user", properties.getProperty("email"));
	        props.put("mail.smtp.password", properties.getProperty("password"));
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");
	        
	        Session session = Session.getDefaultInstance(props, null);
	        MimeMessage message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(properties.getProperty("email")));
	        InternetAddress[] toAddress = new InternetAddress[to.size()];
	        for (int i = 0; i < to.size(); i++) { 
	            toAddress[i] = new InternetAddress(to.get(i));
	        }
	        
	        System.out.println(Message.RecipientType.TO);
	        
	        for (int i = 0; i < toAddress.length; i++) { 
	            message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	        }
	        message.setSubject(subject);

	        message.setContent(content_message, "text/html; charset=\"UTF-8\"");
	        Transport transport = session.getTransport("smtp");
	        transport.connect(host, properties.getProperty("email"), properties.getProperty("password"));
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }

	    catch (Exception e) {
	        System.out.println("Unable to connect");
	    }
	}
	
	public String getEmail() {
		return this.properties.getProperty("email");
	}
}
