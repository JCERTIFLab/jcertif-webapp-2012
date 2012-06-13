/**
 * 
 */
package com.jcertif.web.ihm.home;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jcertif.web.service.ResourceService;
import javax.enterprise.context.ApplicationScoped;

/**
 * @author rossi.oddet
 * 
 */
@Named
@ApplicationScoped
public class HomeBean {

	private static final int NB_DIGIT = 3;
	private static final String PHOTO_EXT = ".JPG";
	private static final int NB_PHOTOS_MAX = 10;

	@Inject
	private ResourceService resourceService;

	public String getImageConference() {
		return "https://lh3.googleusercontent.com/-VDSRjJXi_W0/TnG04Q1UgBI/AAAAAAAACzk/v_ABAZaCZU8/w373-h279-n-k/IMG_0829.JPG";
	}

	public String getImageUniversity() {
		return "https://lh3.googleusercontent.com/-vnTHYTPdJqg/TnQ7X9SDuNI/AAAAAAAADKU/JlPmJHwwpsM/w373-h249-n-k/DSC_0233.JPG";

	}

}
