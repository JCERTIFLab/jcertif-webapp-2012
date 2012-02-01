package com.jcertif.web.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.jcertif.web.model.RoleParticipant;
import com.jcertif.web.model.TypeParticipant;
import com.sun.jersey.api.client.GenericType;

/**
 * Referentiel service.
 * 
 * TODO Cached referentiel resources
 * 
 * @author rossi.oddet
 * 
 */
@Named
public class ReferentielService {

	@Inject
	private ResourceService resourceService;

	@Inject
	private RestService restService;

	/**
	 * @return the typesParticipant
	 */
	public List<TypeParticipant> getTypesParticipantList() {
		return restService.getBuilder(resourceService.getTypeParticipantListContext()).get(
				new GenericType<List<TypeParticipant>>() {
				});
	}

	/**
	 * @return the rolesParticipant
	 */
	public List<RoleParticipant> getRolesParticipantList() {
		return restService.getBuilder(resourceService.getRoleParticipantListContext()).get(
				new GenericType<List<RoleParticipant>>() {
				});
	}

}
