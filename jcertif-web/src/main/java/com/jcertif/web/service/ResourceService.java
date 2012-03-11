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
	 * @return the type participant create context
	 */
	public String getTypeParticipantCreateContext() {
		return getWebappProps().getString("facade.context.typeparticipant.create");
	}

	/**
	 * @return the type participant update context
	 */
	public String getTypeParticipantUpdateContext() {
		return getWebappProps().getString("facade.context.typeparticipant.update");
	}

	/**
	 * @return the type participant delete context
	 */
	public String getTypeParticipantDeleteContext() {
		return getWebappProps().getString("facade.context.typeparticipant.delete");
	}

	/**
	 * @return the type participant get context
	 */
	public String getTypeParticipantGetContext() {
		return getWebappProps().getString("facade.context.typeparticipant.get");
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
	 * @return the role participant list context.
	 */
	public String getSponsorListContext() {
		return getWebappProps().getString("facade.context.sponsor.list");
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
	 * @return the sponsor pictures url
	 */
	public String getSponsorPicsUrl() {
		return getWebappProps().getString("pics.url.sponsor");
	}

	/**
	 * @return the sponsor pictures url
	 */
	public String getSpeakerPhotoUrl() {
		return getWebappProps().getString("photos.url.speaker");
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

	/**
	 * @return speakers list context.
	 */
	public String getSpeakerListContext() {
		return getWebappProps().getString("facade.context.speaker.list");
	}

	/**
	 * @return speakers list context.
	 */
	public String getSpeakerListContext2011() {
		return getWebappProps().getString("facade.context.speaker.2011.list");
	}

	public String getSponsor2011ListContext() {
		return getWebappProps().getString("facade.context.sponsor.2011.list");
	}

	/**
	 * @return events list context.
	 */
	public String getEventListContext() {
		return getWebappProps().getString("facade.context.event.list");
	}

	public String getSuggestCreateContext() {
		return getWebappProps().getString("facade.context.suggest.create");
	}

	public String getSujetListContext() {
		return getWebappProps().getString("facade.context.sujet.list");
	}

	public String getFaqListContext() {
		return getWebappProps().getString("facade.context.faq.list");
	}
}
