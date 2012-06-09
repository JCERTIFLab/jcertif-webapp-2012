package com.jcertif.web.ihm;

import java.util.Locale;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

/**
 * @author rossi.oddet
 * 
 */
@Named
@RequestScoped
public class LocaleBean {

	public void changeLocale(ActionEvent evt) {
		String componentId = evt.getComponent().getId();
		FacesContext context = FacesContext.getCurrentInstance();
		if ("header-locale-fr".equals(componentId)) {
			Locale.setDefault(Locale.FRENCH);
		} else {
			Locale.setDefault(Locale.ENGLISH);
		}

	}

}
