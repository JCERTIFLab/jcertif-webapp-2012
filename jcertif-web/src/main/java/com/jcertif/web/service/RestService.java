package com.jcertif.web.service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

/**
 * Rest Web Service.
 * 
 * @author rossi.oddet
 * 
 */
@Named
public class RestService {

	private Client client;

	@Inject
	private ResourceService resourceService;

	/**
	 * A constructor.
	 */
	public RestService() {
		super();
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		client = Client.create(clientConfig);
	}

	public WebResource.Builder getBuilder(String path) {
		return client.resource(resourceService.getFacadeUrl()).path(path)
				.accept(MediaType.APPLICATION_JSON);
	}

	public <T> T post(String path, T requestEntity, Class<T> boClass) {
		return client.resource(resourceService.getFacadeUrl()).path(path)
				.accept(MediaType.APPLICATION_JSON).post(boClass, requestEntity);
	}

}
