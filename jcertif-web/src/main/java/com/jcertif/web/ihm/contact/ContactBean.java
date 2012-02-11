package com.jcertif.web.ihm.contact;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 * ContactBean
 * @author Mamadou
 *
 */
@Named
@RequestScoped
public class ContactBean {

    private MapModel simpleModel;  
    
	
    public ContactBean() { 
        simpleModel = new DefaultMapModel();  
          
        // Coordinates  
        LatLng coordConf = new LatLng(-4.28030000, 15.258900);  
          
        // TODO
        simpleModel.addOverlay(new Marker(coordConf, "Jcertif conference 2012"));  
       
    }  
  
    public MapModel getSimpleModel() {  
        return simpleModel;  
    }
}
