package com.jcertif.web.ihm.profile;

import com.jcertif.web.ihm.join.JoinBean;
import com.jcertif.web.model.ModifyPassword;
import com.jcertif.web.model.User;
import com.sun.jersey.api.client.UniformInterfaceException;
import org.apache.commons.lang.StringUtils;
import org.primefaces.context.RequestContext;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import javax.validation.ValidationException;
import java.io.IOException;
import java.io.Serializable;

/**
 * Bean profile management.
 * @author rossi.oddet
 */
@Named
@RequestScoped
public class ProfileBean extends JoinBean implements Serializable {

    private String oldPassword;
    private String newPassword;
    private String confirmNewPassword;

    public User getUser() {
        user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("connectedUser");

        if (user == null) {
            user = new User();
        }

        return user;
    }

    @Override
    public void save(ActionEvent actionEvent) throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            // Role is required
            if (StringUtils.isBlank(user.getRole())) {
                throw new ValidationException(resourceService.getLib("join.role.reqmsg"));
            }

            // Type is required
            if (StringUtils.isBlank(user.getTypeUser())) {
                throw new ValidationException(resourceService.getLib("join.type.reqmsg"));
            }

            restService.post(resourceService.getUserUpdateContext(), user, User.class);
            context.addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_INFO, resourceService.getLib("profile.changed"), null));

            // Saving to session the connected user
            context.getExternalContext().getSessionMap().put("connectedUser", user);
        } catch (ValidationException e) {
            context.addMessage("profile",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
        }
    }

    public void saveNewPassword(ActionEvent actionEvent) throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        if (StringUtils.isBlank(getOldPassword()) || StringUtils.isBlank(getNewPassword()) || StringUtils.isBlank(getConfirmNewPassword())) {
            context.addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_ERROR, null, resourceService.getLib("profile.changepassword.komsg")));
        } else {
            ModifyPassword modifyPassword = new ModifyPassword();
            modifyPassword.setEmail(user.getEmail());
            modifyPassword.setOldPassword(getOldPassword());
            modifyPassword.setNewPassword(getNewPassword());
            try {
                restService.getBuilder(resourceService.getModifyPassUserContext() + "/" + referentielService.getConference().getId()).post(modifyPassword);
                context.addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_INFO, null, resourceService.getLib("profile.changepassword.okmsg")));
            } catch (UniformInterfaceException ex) {
                context.addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_ERROR, null, resourceService.getLib("profile.changepassword.komsg")));
            }

        }

        RequestContext.getCurrentInstance().addCallbackParam("newPasswordOK", true);
    }

    public void redirectToLogin(ComponentSystemEvent evt) throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect(
                context.getExternalContext().getRequestContextPath()
                        + "/faces/connect/login.jsf?returnUrl="
                        + context.getExternalContext().getRequestServletPath());
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }
}
