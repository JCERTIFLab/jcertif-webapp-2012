package com.jcertif.web.service;

import java.util.ResourceBundle;

import javax.inject.Named;

/**
 * @author rossi.oddet
 * 
 */
@Named
public final class ResourceService {

	private static final String ROLE_PARTICIPANT_LIST_CONTEXT = "facade.context.roleparticipant.list";
	public static final String WEBAPP_PROPERTIES_FILE = "jcertif-web";
	public static final String FACADE_URL = "facade.url";
	public static final String USER_CREATE_CONTEXT = "facade.context.user.create";
	public static final String TYPE_PARTIPANT_LIST_CONTEXT = "facade.context.typeparticipant.list";
	public static final String CONFERENCE_CONTEXT = "facade.context.conference";

	public String getFacadeUrl() {
		return getWebappProps().getString(FACADE_URL);
	}

	public String getUserCreateContext() {
		return getWebappProps().getString(USER_CREATE_CONTEXT);
	}

	public ResourceBundle getWebappProps() {
		return ResourceBundle.getBundle(ResourceService.WEBAPP_PROPERTIES_FILE);
	}

	public String getTypeParticipantListContext() {
		return getWebappProps().getString(TYPE_PARTIPANT_LIST_CONTEXT);
	}

	public String getRoleParticipantListContext() {
		return getWebappProps().getString(ROLE_PARTICIPANT_LIST_CONTEXT);
	}

	public String getConferenceContext() {
		return getWebappProps().getString(CONFERENCE_CONTEXT);
	}

}
