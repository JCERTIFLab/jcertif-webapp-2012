package com.jcertif.web.ihm.speaker;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jcertif.web.model.Speaker;
import com.jcertif.web.service.ReferentielService;
import com.jcertif.web.service.ResourceService;
import javax.enterprise.context.ApplicationScoped;

/**
 * SpeakerBean
 * 
 * @author Mamadou
 * 
 */
@Named
@ApplicationScoped
public class SpeakerBean {

	@Inject
	private ResourceService resService;

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
        
        public Speaker getSpeaker(final String nom, final String prenom) {
            
            for(Speaker speaker : referentielService.getSpeakers()) {
                if(nom.equalsIgnoreCase(speaker.getNom()) && prenom.equalsIgnoreCase(prenom)) {
                    return speaker;
                }
            }
            
            return null;
        }

	/**
	 * @return the speakers
	 */
	public List<Speaker> getSpeakers2011() {
		return referentielService.getSpeakers2011();
	}

	public String getSpeakerPhotoUrl() {
		return resService.getImgPicsUrl();
	}

}
