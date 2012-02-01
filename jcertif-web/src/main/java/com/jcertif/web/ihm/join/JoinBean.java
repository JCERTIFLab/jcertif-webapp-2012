package com.jcertif.web.ihm.join;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.jcertif.web.model.RoleParticipant;
import com.jcertif.web.model.TypeParticipant;
import com.jcertif.web.model.User;
import com.jcertif.web.service.ReferentielService;
import com.jcertif.web.service.ResourceService;
import com.jcertif.web.service.RestService;

/**
 * Join Bean.
 * 
 * @author rossi.oddet
 * 
 */
@Named
@RequestScoped
public class JoinBean {

	private User user;

	/** REST Web Service **/
	@Inject
	private RestService restService;

	/** Resource Service **/
	@Inject
	private ResourceService resourceService;

	/** Referentiel Service **/
	@Inject
	private ReferentielService referentielService;

	/**
	 * A default constructor.
	 */
	public JoinBean() {
		super();
		this.user = new User();
	}

	/**
	 * @param actionEvent
	 *            a action event
	 * @throws IOException
	 *             if redirect error
	 */
	public void save(ActionEvent actionEvent) throws IOException {
		if (!user.getEmail().equals(user.getConfirmemail())) {
			FacesContext.getCurrentInstance().addMessage("join:confirm",
					new FacesMessage("C'est mort"));

		} else {
			restService.post(resourceService.getUserCreateContext(), user, User.class);
			FacesContext
					.getCurrentInstance()
					.getExternalContext()
					.redirect(
							FacesContext.getCurrentInstance().getExternalContext()
									.getRequestContextPath()
									+ "/faces/join/confirmationJoin.jsf");
		}

	}

	/**
	 * @return the typesParticipant
	 */
	public List<TypeParticipant> getTypesParticipant() {
		return referentielService.getTypesParticipantList();
	}

	/**
	 * @return the rolesParticipant
	 */
	public List<RoleParticipant> getRolesParticipant() {
		return referentielService.getRolesParticipantList();
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
