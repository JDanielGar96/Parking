package com.unbosque.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.unbosque.dao.impl.ParqueaderoDAOImpl;
import com.unbosque.entity.Parqueadero;

@ManagedBean
@ViewScoped
public class MapaBean implements Serializable {

	/**
	 * Administra las propiedades de los mapas en la aplicación
	 */
	private static final long serialVersionUID = 1L;
	
	private Parqueadero parqueadero;
	
	private MapModel modeloMapa;
	private Marker marker;
	
	public MapaBean() {
		List<Object> parqueaderos = new ParqueaderoDAOImpl().listAvaliables();
		modeloMapa = new DefaultMapModel();
        System.out.println("Hera i'm");
        //Shared coordinates
		for(Object objParqueadero: parqueaderos) {
			Parqueadero parqueadero = (Parqueadero) objParqueadero;
			LatLng coord = new LatLng(parqueadero.getLatitud(), parqueadero.getLongitud());
			modeloMapa.addOverlay(new Marker(coord, String.valueOf(parqueadero.getId())));
		}	
	}
	
    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
        
        int id = Integer.parseInt(marker.getTitle());
        parqueadero = (Parqueadero) new ParqueaderoDAOImpl().get(id);
        System.out.println(parqueadero.getDisponibilidad());
    }
    
    public Parqueadero getParqueadero() {
    	return parqueadero;
    }
      
    public Marker getMarker() {
        return marker;
    }
    
	public MapModel getModeloMapa() {
		return modeloMapa;
	}
	
	
}
