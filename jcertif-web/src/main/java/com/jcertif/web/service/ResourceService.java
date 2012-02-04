package com.jcertif.web.service;

import java.util.ResourceBundle;

import javax.inject.Named;

/**
 * Resource Service.
 * 
 * @author rossi.oddet
 * 
 */
@Named
public final class ResourceService {

	private static final String ROLE_PARTICIPANT_LIST_CONTEXT = "facade.context.roleparticipant.list";
	public static final String WEBAPP_PROPERTIES_FILE = "jcertif-web";
	public static final String LIBELLE_PROPERTIES_FILE = "i18n/libelles";
	public static final String FACADE_URL = "facade.url";
	public static final String USER_CREATE_CONTEXT = "facade.context.user.create";
	public static final String TYPE_PARTIPANT_LIST_CONTEXT = "facade.context.typeparticipant.list";
	public static final String CONFERENCE_CONTEXT = "facade.context.conference";

	/**
	 * @return the facade url
	 */
	public String getFacadeUrl() {
		return getWebappProps().getString(FACADE_URL);
	}

	/**
	 * @return the user create context
	 */
	public String getUserCreateContext() {
		return getWebappProps().getString(USER_CREATE_CONTEXT);
	}

	/**
	 * @return the webapp resource bundle
	 */
	public ResourceBundle getWebappProps() {
		return ResourceBundle.getBundle(ResourceService.WEBAPP_PROPERTIES_FILE);
	}

	public ResourceBundle getLibProps() {
		return ResourceBundle.getBundle(ResourceService.LIBELLE_PROPERTIES_FILE);
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

	/**
	 * @param key
	 *            a key
	 * @return the value of this key
	 */
	public String getLib(String key) {
		return getLibProps().getString(key);
	}

}
