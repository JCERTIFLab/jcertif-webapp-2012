package com.jcertif.web.ihm.home;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.jcertif.web.model.Sponsor;
import com.jcertif.web.model.SponsorComparator;
import com.jcertif.web.service.ReferentielService;
import com.jcertif.web.service.ResourceService;
import javax.enterprise.context.ApplicationScoped;

/**
 * @author rossi.oddet
 * 
 */
@Named
@ApplicationScoped
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
		List<Sponsor> sponsors = referentielService.getSponsors();
		Collections.sort(sponsors, new SponsorComparator());
		return referentielService.getSponsors();
	}

	/**
	 * @return images location for conference
	 */
	public List<Sponsor> getSponsors2011() {
		return referentielService.getSponsors2011();
	}

	public String getPicsUrl() {
		return resService.getImgPicsUrl();
	}

}
