/**
 * 
 */
package com.jcertif.web.ihm.home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 * @author rossi.oddet
 * 
 */
@Named
@RequestScoped
public class HomeBean {

	private static final String CONF_REP = "/resources/img/carousel/conference/";
	private static final String UNIV_REP = "/resources/img/carousel/university/";
	private static final String[] CONF_PHOTOS = new String[] { "0001.jpg", "0002.jpg", "0003.jpg",
			"0004.jpg", };
	private static final String[] UNIV_PHOTOS = new String[] { "0001.jpg", "0002.jpg", "0003.jpg",
			"0004.jpg", };

	/**
	 * @return images location for conference
	 */
	public List<String> getImagesConference() {
		List<String> photos = new ArrayList<String>();

		for (String photo : Arrays.asList(CONF_PHOTOS)) {
			photos.add(CONF_REP + photo);
		}

		return photos;
	}

	/**
	 * @return images location for university
	 */
	public List<String> getImagesUniversity() {
		List<String> photos = new ArrayList<String>();

		for (String photo : Arrays.asList(UNIV_PHOTOS)) {
			photos.add(UNIV_REP + photo);
		}

		return photos;

	}

}
