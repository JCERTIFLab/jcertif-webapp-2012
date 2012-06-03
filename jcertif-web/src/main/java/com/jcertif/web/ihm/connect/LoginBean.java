package com.jcertif.web.ihm.connect;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang.StringUtils;

import com.jcertif.web.model.User;
import com.jcertif.web.service.ReferentielService;
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

	@Inject
	private ReferentielService refservice;

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
		if (StringUtils.isBlank(user.getPasswd())) {
			context.addMessage("loginForm:password", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					resourceService.getLib("login.password.reqmsg"), null));
		} else {
			User findedUser = restService.getBuilder(
					resourceService.getConnectUserContext() + "/" + user.getEmail() + "/"
							+ user.getPasswd() + "/" + refservice.getConference().getId()).get(
					User.class);
			if (findedUser == null || findedUser.getId() == null) {
				context.addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_ERROR,
						resourceService.getLib("login.unsuccess"), null));
			} else {
				// Saving to session the connected user
				context.getExternalContext().getSessionMap().put("connectedUser", findedUser);
				String returnUrl = "/faces/home/home.jsf";
				if (context.getExternalContext().getFlash().containsKey("returnUrl")) {
					returnUrl = (String) context.getExternalContext().getFlash().get("returnUrl");
				}
				context.getExternalContext().redirect(
						context.getExternalContext().getRequestContextPath() + returnUrl);
			}
		}

	}

	/**
	 * Connect action.
	 * 
	 * @throws IOException
	 */
	public void reset() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		User existingUser = restService.getBuilder(
				resourceService.getUserContext() + "/" + user.getEmail() + "/"
						+ refservice.getConference().getId()).get(User.class);
		if (existingUser.getId() == null) {
			context.addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					resourceService.getLib("login.reset.error"), null));
		} else {
			restService.getBuilder(
					resourceService.getResetPassUserContext() + "/" + user.getEmail() + "/"
                            + refservice.getConference().getId()).post();
			context.addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_INFO,
					resourceService.getLib("login.reset.success"), null));
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
