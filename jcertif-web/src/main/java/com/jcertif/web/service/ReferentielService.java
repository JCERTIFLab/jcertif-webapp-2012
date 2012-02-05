package com.jcertif.web.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.web.model.Conference;
import com.jcertif.web.model.RoleParticipant;
import com.jcertif.web.model.TypeParticipant;
import com.sun.jersey.api.client.GenericType;

/**
 * Referentiel service.
 * 
 * @author rossi.oddet
 * 
 */
@Named
@ApplicationScoped
public class ReferentielService {

	private static final class TypeParticipantType extends GenericType<List<TypeParticipant>> {
	}

	private static final class RoleParticipantType extends GenericType<List<RoleParticipant>> {
	}

	/** LOGGER **/
	private static final Logger LOG = LoggerFactory.getLogger(ReferentielService.class);

	@Inject
	private ResourceService resourceService;

	@Inject
	private RestService restService;

	private List<TypeParticipant> typeParticipants;

	private List<RoleParticipant> roleParticipants;

	/** Conference **/
	private Conference conference;

	/**
	 * @return the typesParticipant
	 */
	public List<TypeParticipant> getTypesParticipantList() {
		if (typeParticipants == null) {
			typeParticipants = restService.getBuilder(
					resourceService.getTypeParticipantListContext()).get(new TypeParticipantType());
		}
		return typeParticipants;
	}

	/**
	 * @return the rolesParticipant
	 */
	public List<RoleParticipant> getRolesParticipantList() {
		if (roleParticipants == null) {
			roleParticipants = restService.getBuilder(
					resourceService.getRoleParticipantListContext()).get(new RoleParticipantType());
		}
		return roleParticipants;

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
