package com.jcertif.web.ihm.connect;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.jcertif.web.model.User;
import com.jcertif.web.service.ResourceService;
import com.jcertif.web.service.RestService;

/**
 * Login Bean.
 * 
 * @author rossi.oddet
 * 
 */
@Named
@RequestScoped
public class LoginBean {

	private User user;

	/** REST Web Service **/
	@Inject
	private RestService restService;

	/** Resource Service **/
	@Inject
	private ResourceService resourceService;

	/**
	 * A constructor.
	 */
	public LoginBean() {
		super();
		this.user = new User();
	}

	/**
	 * Connect action.
	 * 
	 * @throws IOException
	 */
	public void connect() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		user = restService.getBuilder(
				resourceService.getConnectUserContext() + "/" + user.getEmail() + "/"
						+ user.getPasswd()).get(User.class);
		System.out.println(resourceService.getConnectUserContext() + "/" + user.getEmail() + "/"
				+ user.getPasswd());
		if (user.getId() == null) {
			context.addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					resourceService.getLib("login.unsuccess"), null));
		} else {
			// Saving to session the connected user
			context.getExternalContext().getSessionMap().put("connectedUser", user);
			context.getExternalContext().redirect(
					context.getExternalContext().getRequestContextPath() + "/faces/home/home.jsf");
		}
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
