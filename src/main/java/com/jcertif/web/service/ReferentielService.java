package com.jcertif.web.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.codehaus.jackson.annotate.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.web.model.Conference;
import com.jcertif.web.model.Event;
import com.jcertif.web.model.Faq;
import com.jcertif.web.model.RoleParticipant;
import com.jcertif.web.model.Speaker;
import com.jcertif.web.model.Sponsor;
import com.jcertif.web.model.SponsorComparator;
import com.jcertif.web.model.Sujet;
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
public class ReferentielService implements Serializable {

	private static class TypeParticipantContainer {
		@JsonProperty("typeParticipant")
		private List<TypeParticipant> list;
	}

	private static class SujetContainer {
		@JsonProperty("sujet")
		private List<Sujet> list;
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

	private static class EventContainer {
		@JsonProperty("event")
		private List<Event> list;
	}

	private static class FaqContainer {
		@JsonProperty("faq")
		private List<Faq> list;
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

	private List<Event> events;

	private List<Sujet> sujets;

	private List<Faq> faqs;

	/** Conference **/
	private Conference conference;

	private List<Sponsor> sponsors2012;

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
		if (sponsors2012 == null) {
			sponsors2012 = restService.getBuilder(resourceService.getSponsorListContext()).get(
					SponsorContainer.class).list;
			Collections.sort(sponsors2012, new SponsorComparator());
		}
		return sponsors2012;

	}

	/**
	 * @return the speakers
	 */
	public List<Speaker> getSpeakers() {
		if (speakers == null) {
			speakers = restService.getBuilder(resourceService.getSpeakerListContext()).get(
					SpeakerContainer.class).list;
		}
		return speakers;

	}

    public Speaker getSpeaker(Long id) {
        for(Speaker speaker : getSpeakers()){
            if(speaker.getId().equals(id)){
                return speaker;
            }
        }
        return null;

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
				speakers2011
						.add(new Speaker(restService.getBuilder(
								resourceService.getUserContext() + "/" + email + "/" + "1").get(
								User.class)));

			}

		}
		return speakers2011;
	}

	/**
	 * @return the events
	 */
	public List<Event> getEvents() {

		if (events == null) {
			events = restService.getBuilder(resourceService.getEventListContext()).get(
					EventContainer.class).list;
		}

		return events;
	}

	public List<Sujet> getSujets() {
		if (sujets == null) {
			sujets = restService.getBuilder(resourceService.getSujetListContext()).get(
					SujetContainer.class).list;
		}
		return sujets;

	}

	public List<Faq> getFaqs() {
		if (faqs == null) {
			faqs = restService.getBuilder(resourceService.getFaqListContext()).get(
					FaqContainer.class).list;
		}
		return faqs;
	}

}
