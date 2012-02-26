package com.jcertif.web.service;

import java.util.ArrayList;
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
import com.jcertif.web.model.User;

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

	private String[] speakers2011Email = new String[] { "arun.p.gupta@oracle.com",
			"matayobweta@gmail.com", "bonbhel@gmail.com", "rossi.oddet@gmail.com", };

	@Inject
	private ResourceService resourceService;

	@Inject
	private RestService restService;

	private List<TypeParticipant> typeParticipants;

	private List<RoleParticipant> roleParticipants;

	private List<Sponsor> sponsors2011;

	private List<Speaker> speakers;

	private List<Speaker> speakers2011;

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
		if (sponsors2011 == null) {
			sponsors2011 = restService.getBuilder(resourceService.getSponsorListContext()).get(
					SponsorContainer.class).list;
		}
		return sponsors2011;

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

	public List<Sponsor> getSponsors2011() {
		if (sponsors2011 == null) {
			sponsors2011 = restService.getBuilder(resourceService.getSponsor2011ListContext()).get(
					SponsorContainer.class).list;
		}
		return sponsors2011;
	}

	public List<Speaker> getSpeakers2011() {
		if (speakers2011 == null) {
			speakers2011 = new ArrayList<Speaker>();

			for (String email : speakers2011Email) {
				speakers2011.add(new Speaker(restService.getBuilder(
						resourceService.getUserContext() + "/" + email).get(User.class)));

			}

		}
		return speakers2011;
	}
}
