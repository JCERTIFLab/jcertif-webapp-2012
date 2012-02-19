/**
 * Created on [19 févr. 2012 05:17:49]
 */
package com.jcertif.web.service;

import java.util.ArrayList;
import java.util.List;

import com.jcertif.web.model.TypeParticipant;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;

/**
 * @author Olivier MBIELEU
 * 
 */
public class TypeParticipantService extends RestServiceJS {

	private static final class TypeParticipantType extends
			GenericType<List<TypeParticipant>> {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcertif.web.service.RestServiceJS#add(java.lang.Object)
	 */
	@Override
	public void add(Object unTypeParticipant) {
		// TODO Auto-generated method stub
		clearErr();

		TypeParticipant aTypeParticipant = (TypeParticipant) unTypeParticipant;
		try {
			getBuilder(getResourceService().getTypeParticipantCreateContext())
					.post(TypeParticipant.class, aTypeParticipant);
		} catch (UniformInterfaceException uieEx) {
			setErrMessage(uieEx.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcertif.web.service.RestServiceJS#update(java.lang.Object)
	 */
	@Override
	public void update(Object unTypeParticipant) {
		// TODO Auto-generated method stub
		clearErr();

		TypeParticipant aTypeParticipant = (TypeParticipant) unTypeParticipant;
		try {
			getBuilder(getResourceService().getTypeParticipantUpdateContext())
					.post(TypeParticipant.class, aTypeParticipant);
		} catch (UniformInterfaceException uieEx) {
			setErrMessage(uieEx.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcertif.web.service.RestServiceJS#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object unTypeParticipant) {
		// TODO Auto-generated method stub
		clearErr();

		TypeParticipant aTypeParticipant = (TypeParticipant) unTypeParticipant;
		try {
			getBuilder(getResourceService().getTypeParticipantDeleteContext())
					.post(TypeParticipant.class, aTypeParticipant);
		} catch (UniformInterfaceException uieEx) {
			setErrMessage(uieEx.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcertif.web.service.RestServiceJS#get(java.lang.Object)
	 */
	@Override
	public Object get(Object unTypeParticipant) {
		// TODO Auto-generated method stub
		clearErr();

		TypeParticipant aTypeParticipant = (TypeParticipant) unTypeParticipant;

		TypeParticipant retTypeParticipant = new TypeParticipant();
		try {
			retTypeParticipant = getBuilder(
					getResourceService().getTypeParticipantGetContext()
							+ (new Long(aTypeParticipant.getId()))).post(
					TypeParticipant.class);
		} catch (UniformInterfaceException uieEx) {
			setErrMessage(uieEx.getMessage());
		}
		return retTypeParticipant;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcertif.web.service.RestServiceJS#listAll()
	 */
	@Override
	public List<TypeParticipant> listAll() {
		// TODO Auto-generated method stub
		clearErr();

		List<TypeParticipant> retListTypeParticipant = new ArrayList<TypeParticipant>();
		try {
			retListTypeParticipant = getBuilder(
					getResourceService().getTypeParticipantListContext()).get(
					new TypeParticipantType());
		} catch (UniformInterfaceException uieEx) {
			setErrMessage(uieEx.getMessage());
		}
		return retListTypeParticipant;
	}

}
