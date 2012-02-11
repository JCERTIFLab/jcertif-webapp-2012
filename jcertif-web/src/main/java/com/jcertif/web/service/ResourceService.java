package com.jcertif.web.service;

import java.util.ResourceBundle;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * Resource Service.
 * 
 * @author rossi.oddet
 * 
 */
@Named
@ApplicationScoped
public class ResourceService {

	/**
	 * @return the facade url
	 */
	public String getFacadeUrl() {
		return getWebappProps().getString("facade.url");
	}

	/**
	 * @return the user create context
	 */
	public String getUserCreateContext() {
		return getWebappProps().getString("facade.context.user.create");
	}

	/**
	 * @return the webapp resource bundle
	 */
	public ResourceBundle getWebappProps() {
		return ResourceBundle.getBundle("jcertif-web");
	}

	/**
	 * @return the libelle properties resource bundle.
	 */
	public ResourceBundle getLibProps() {
		return ResourceBundle.getBundle("i18n/libelles");
	}

	/**
	 * @return the type participant list context
	 */
	public String getTypeParticipantListContext() {
		return getWebappProps().getString("facade.context.typeparticipant.list");
	}

	/**
	 * @return the role participant list context.
	 */
	public String getRoleParticipantListContext() {
		return getWebappProps().getString("facade.context.roleparticipant.list");
	}

	/**
	 * @return the conference web service context
	 */
	public String getConferenceContext() {
		return getWebappProps().getString("facade.context.conference");
	}

	/**
	 * @return the user web service context.
	 */
	public String getUserContext() {
		return getWebappProps().getString("facade.context.user");
	}

	/**
	 * @param key
	 *            a key
	 * @return the value of this key
	 */
	public String getLib(String key) {
		return getLibProps().getString(key);
	}

	public String getConnectUserContext() {
		return getWebappProps().getString("facade.context.user.connect");
	}

	public String getResetPassUserContext() {
		return getWebappProps().getString("facade.context.user.resetpassword");
	}

}
