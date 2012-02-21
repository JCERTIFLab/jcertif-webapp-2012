package com.jcertif.web.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.codehaus.jackson.annotate.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.web.model.Conference;
import com.jcertif.web.model.RoleParticipant;
import com.jcertif.web.model.Speaker;
import com.jcertif.web.model.Sponsor;
import com.jcertif.web.model.TypeParticipant;

/**
 * Referentiel service.
 * 
 * @author rossi.oddet
 * 
 */
@Named
@ApplicationScoped
public class ReferentielService {

	private static class TypeParticipantContainer {
		@JsonProperty("typeParticipant")
		private List<TypeParticipant> list;
	}

	private static class RoleParticipantContainer {
		@JsonProperty("roleParticipant")
		private List<RoleParticipant> list;
	}

	private static class SponsorContainer {
		@JsonProperty("sponsor")
		private List<Sponsor> list;
	}

	private static class SpeakerContainer {
		@JsonProperty("speaker")
		private List<Speaker> list;
	}

	/** LOGGER **/
	private static final Logger LOG = LoggerFactory.getLogger(ReferentielService.class);

	@Inject
	private ResourceService resourceService;

	@Inject
	private RestService restService;

	private List<TypeParticipant> typeParticipants;

	private List<RoleParticipant> roleParticipants;

	private List<Sponsor> sponsors;

	private List<Speaker> speakers;

	/** Conference **/
	private Conference conference;

	/**
	 * @return the typesParticipant
	 */
	public List<TypeParticipant> getTypesParticipantList() {
		if (typeParticipants == null) {
			typeParticipants = restService.getBuilder(
					resourceService.getTypeParticipantListContext()).get(
					TypeParticipantContainer.class).list;
		}
		return typeParticipants;
	}

	/**
	 * @return the rolesParticipant
	 */
	public List<RoleParticipant> getRolesParticipantList() {
		if (roleParticipants == null) {
			roleParticipants = restService.getBuilder(
					resourceService.getRoleParticipantListContext()).get(
					RoleParticipantContainer.class).list;
		}
		return roleParticipants;

	}

	/**
	 * @return the rolesParticipant
	 */
	public List<Sponsor> getSponsors() {
		if (sponsors == null) {
			sponsors = restService.getBuilder(resourceService.getSponsorListContext()).get(
					SponsorContainer.class).list;
		}
		return sponsors;

	}

	/**
	 * @return the speaker
	 */
	public List<Speaker> getSpeakers() {
		if (speakers == null) {
			speakers = restService.getBuilder(resourceService.getSpeakerListContext()).get(
					SpeakerContainer.class).list;
		}
		return speakers;

	}

	/**
	 * @return the conference
	 */
	public Conference getConference() {
		if (conference == null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[START] Retrieving Conference..."
						+ resourceService.getConferenceContext());
			}
			conference = restService.getBuilder(resourceService.getConferenceContext()).get(
					Conference.class);
			if (LOG.isDebugEnabled()) {
				LOG.debug("[END] Retrieving Conference");
			}
		}
		return conference;
	}

}
