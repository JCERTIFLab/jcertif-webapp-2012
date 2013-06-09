package com.jcertif.web.service;

import java.io.Serializable;
import java.util.ResourceBundle;
import java.util.Scanner;

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
public class ResourceService implements Serializable {

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
     * @return the user create context
     */
    public String getUserUpdateContext() {
        return getWebappProps().getString("facade.context.user.update");
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
	public String getImgPicsUrl() {
		return getWebappProps().getString("pics.img.url");
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

    public String getModifyPassUserContext() {
        return getWebappProps().getString("facade.context.user.modifypassword");
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

	public String getUserUpdateBioContext() {
		return getWebappProps().getString("facade.context.user.update.bio");
	}
	
	public String getAndroidDoc2011(){
		return getWebappProps().getString("pics.url.doc.2011.android");
	}
	
	public String getJavaDoc2011(){
		return getWebappProps().getString("pics.url.doc.2011.java");
	}

	public String getPhotoUnivEvent2011Url() {
		return getWebappProps().getString("pics.url.img.2011.univ");
	}

	public String getPhotoConfEvent2011Url() {
		return getWebappProps().getString("pics.url.img.2011.conf");
	}

    public String getMailHost() {
        return getWebappProps().getString("mail.host");
    }

    public Integer getMailPort() {
        return Integer.valueOf(getWebappProps().getString("mail.port"));
    }

    public String getMailUser() {
        return getWebappProps().getString("mail.user");
    }

    public String getMailPassword() {
        return getWebappProps().getString("mail.pass");
    }

    public String getMailDiffusion() {
        return getWebappProps().getString("mail.diffusion");
    }

    public String get() {
        return getWebappProps().getString("mail.filename");
    }

    public String getMailTempDir() {
        return getWebappProps().getString("mail.temp.dir");
    }

    public String getWaridMailTemplate() {
        StringBuilder htmlTemplate = new StringBuilder();
        Scanner sc = new Scanner(Thread.currentThread().getContextClassLoader().getResourceAsStream("mail/waridTemplate.html"));
        while(sc.hasNext()){
            htmlTemplate.append(sc.nextLine());
        }
        return htmlTemplate.toString();
    }

}
