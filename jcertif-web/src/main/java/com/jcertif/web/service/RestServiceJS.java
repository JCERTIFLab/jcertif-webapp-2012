/**
 * Created on [18 févr. 2012 16:28:31]
 */
package com.jcertif.web.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.MediaType;

import com.jcertif.web.utils.Tools;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

/**
 * @author Olivier MBIELEU
 * 
 */
@Named
public abstract class RestServiceJS {
	private final Client client;

	@Inject
	private final ResourceService resourceService;

	/**
	 * errCode représente le code d'erreur retourné par le dernier appel à un
	 * webService. Un code d'erreur 0 signifie qu'il n'y a pas eu d'erreur
	 */
	private int errCode;

	/**
	 * errMessage représente le message d'erreur retourné par le dernier appel à
	 * un webService
	 */
	private String errMessage;

	public RestServiceJS() {
		super();
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		client = Client.create(clientConfig);
		resourceService = new ResourceService();
		clearErr();
	}

	/**
	 * @return the resourceService
	 */
	protected ResourceService getResourceService() {
		return resourceService;
	}

	protected WebResource.Builder getBuilder(String path) {
		return client.resource(resourceService.getFacadeUrl()).path(path)
				.accept(MediaType.APPLICATION_JSON);
	}

	protected void clearErr() {
		errCode = 0;
		errMessage = "";
	}

	/**
	 * @return the errCode
	 */
	public int getErrCode() {

		if (errCode != 0) return errCode;

		if (Tools.isEmptyOrNull(errMessage)) errCode = 0;
		else {
			// Cette recherche du code de la réponse du webService est à
			// éprouver
			String[] strArray = Tools.split(errMessage,
					"returned a response status of");
			if (strArray.length != 2) errCode = -1;// Dans ce cas, la variable
			// errMessage contient le
			// message complet et la
			// valeur de errCode n'est
			// pas valide
			else {
				if (!Tools.isEmptyOrNull(strArray[1])) try {
					errCode = Integer.parseInt(strArray[1]);
				} catch (Exception ex) {
					errCode = -1;// Invalid Value
				}
			}
		}

		return errCode;
	}

	/**
	 * @param errCode
	 *            the errCode to set
	 */
	protected void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	/**
	 * @return the errMessage
	 */
	public String getErrMessage() {
		return errMessage;
	}

	/**
	 * @param errMessage
	 *            the errMessage to set
	 */
	protected void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	/**
	 * Cette fonction permet d'ajouter un objet dans la base de données via
	 * JCertif-facade
	 * 
	 * @param anObject
	 */
	public abstract void add(Object anObject);

	/**
	 * Cette fonction permet de mettre à jout un objet dans la base de données
	 * via JCertif-facade
	 * 
	 * @param anObject
	 */
	public abstract void update(Object anObject);

	/**
	 * Cette fonction permet de supprimer un objet dans la base de données via
	 * JCertif-facade
	 * 
	 * @param anObject
	 */
	public abstract void delete(Object anObject);

	/**
	 * Cette fonction permet de récupérer un objet dans la base de données via
	 * JCertif-facade
	 * 
	 * @param anObject
	 * @return
	 */
	public abstract Object get(Object anObject);

	/**
	 * Cette fonction permet de lister tous les objets d'une table dans la base
	 * de données via JCertif-facade
	 * 
	 * @return
	 */
	public abstract List<?> listAll();

}
