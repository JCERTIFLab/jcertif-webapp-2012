package com.jcertif.web.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.MediaType;
import com.jcertif.web.model.TypeParticipant;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

/**
 * @author rossi.oddet
 * 
 */
@Named
public class RestService {

	private Client client;

	@Inject
	private ResourceService resourceService;

	public RestService() {
		super();
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		client = Client.create(clientConfig);
	}

	public WebResource.Builder getBuilder(String path) {
		return client.resource(resourceService.getFacadeUrl()).path(path)
				.accept(MediaType.APPLICATION_XML);
	}

	public List<TypeParticipant> getType(String path) {
		return client.resource(resourceService.getFacadeUrl()).path(path)
				.accept(MediaType.APPLICATION_XML).get(new GenericType<List<TypeParticipant>>() {
				});
	}

	public <T> List<T> post(String path) {
		return client.resource(resourceService.getFacadeUrl()).path(path)
				.accept(MediaType.APPLICATION_JSON).post(new GenericType<List<T>>() {
				});
	}

	public <T> T post(String path, T requestEntity, Class<T> boClass) {
		return client.resource(resourceService.getFacadeUrl()).path(path)
				.accept(MediaType.APPLICATION_XML).post(boClass, requestEntity);
	}

}
