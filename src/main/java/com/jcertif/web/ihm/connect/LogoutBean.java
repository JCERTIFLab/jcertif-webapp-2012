package com.jcertif.web.ihm.connect;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * Join Bean.
 * 
 * @author rossi.oddet
 * 
 */
@Named
@RequestScoped
public class LogoutBean {

	/**
	 * A constructor.
	 */
	public LogoutBean() {
		super();
	}

	/**
	 * Logout.
	 * 
	 * @throws IOException
	 */
	public void logout() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().invalidateSession();
		context.getExternalContext().redirect(
				context.getExternalContext().getRequestContextPath() + "/faces/home/home.jsf");
	}

}
