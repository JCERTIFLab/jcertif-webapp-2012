package com.jcertif.web.ihm.warid;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ValidationException;

import com.jcertif.web.model.Warid;
import com.jcertif.web.service.ResourceService;

@Named
@ApplicationScoped
public class WaridBean extends Warid {
	
	@Inject
	protected ResourceService resourceService;

	public void register(){
		if(getFile() == null) {
			throw new ValidationException(resourceService.getLib("warid.file") + " " + resourceService.getLib("warid.mandatory"));
		}
		System.out.println("Register Warid " + this.toString());
	}
}
