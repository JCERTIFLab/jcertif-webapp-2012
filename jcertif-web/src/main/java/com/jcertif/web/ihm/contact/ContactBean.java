package com.jcertif.web.ihm.contact;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.jcertif.web.model.Faq;
import com.jcertif.web.service.ReferentielService;

/**
 * ContactBean
 * 
 * @author Mamadou
 * 
 */
@Named
@RequestScoped
public class ContactBean {

	private MapModel simpleModel;

	/** Referentiel Service **/
	@Inject
	private ReferentielService referentielService;

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

	public List<Faq> getFaqs() {
		return referentielService.getFaqs();
	}
}
