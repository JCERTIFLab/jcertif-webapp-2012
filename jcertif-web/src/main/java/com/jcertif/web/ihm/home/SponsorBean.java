package com.jcertif.web.ihm.home;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jcertif.web.model.Sponsor;
import com.jcertif.web.service.ReferentielService;
import com.jcertif.web.service.ResourceService;

/**
 * @author rossi.oddet
 * 
 */
@Named
@RequestScoped
public class SponsorBean {

	/** Referentiel Service **/
	@Inject
	private ReferentielService referentielService;

	@Inject
	private ResourceService resService;

	/**
	 * @return images location for conference
	 */
	public List<Sponsor> getSponsors() {
		return referentielService.getSponsors();
	}

	/**
	 * @return images location for conference
	 */
	public List<Sponsor> getSponsors2011() {
		return referentielService.getSponsors2011();
	}

	public String getPicsUrl() {
		return resService.getSponsorPicsUrl();
	}

}
