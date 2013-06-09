package com.jcertif.web.ihm.warid;

import com.jcertif.web.model.Warid;
import com.jcertif.web.service.EmailService;
import com.jcertif.web.service.ResourceService;
import org.primefaces.event.FileUploadEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class WaridBean extends Warid {

    private static final Logger LOG = LoggerFactory.getLogger(EmailService.class);


    @Inject
	protected ResourceService resourceService;

    @Inject
    private EmailService emailService;

	public void register(ActionEvent actionEvent){
        LOG.info(this.toString());
        if(getFile() == null) {
            FacesContext.getCurrentInstance().addMessage("warid",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez joindre votre document rempli", null));
        } else {
            if(emailService.sendWarid(this)) {
                FacesContext.getCurrentInstance().addMessage("warid",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Merci pour votre candidature. Vous allez recevoir un email de confirmation.", null));
            } else {
                FacesContext.getCurrentInstance().addMessage("warid",
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Une erreur technique est survenue, veuillez envoyer votre candidature par email", null));
            }
        }

	}

    public void handleFileUpload(FileUploadEvent event) {
        setFile(event.getFile());
    }

    public String getFileText(){
        if (getFile() == null) {
            return resourceService.getLib("warid.file1") ;
        } else {
            return resourceService.getLib("warid.file2") + " " + getFile().getFileName();
        }
    }
}
