package com.jcertif.web.ihm.speaker;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jcertif.web.model.Speaker;
import com.jcertif.web.service.ReferentielService;
import com.jcertif.web.service.ResourceService;
import com.jcertif.web.service.RestService;

/**
 * SpeakerBean
 * 
 * @author Mamadou
 * 
 */
@Named
@RequestScoped
public class SpeakerBean {

	@Inject
	private ResourceService resService;

	/** REST Web Service **/
	@Inject
	private RestService restService;

	/** Referentiel Service **/
	@Inject
	private ReferentielService referentielService;

	/**
	 * A default constructor.
	 */
	public SpeakerBean() {
		super();
	}

	/**
	 * @return the speakers
	 */
	public List<Speaker> getSpeakers() {
		return referentielService.getSpeakers();
	}

	/**
	 * @return the speakers
	 */
	public List<Speaker> getSpeakers2011() {
		return referentielService.getSpeakers2011();
	}

	public String getSpeakerPhotoUrl() {
		return resService.getSpeakerPhotoUrl();
	}

}
