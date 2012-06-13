package com.jcertif.web.ihm.home;

import com.jcertif.web.service.ResourceService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * @return images location for conference
     */
    public List<String> getImagesConference() {
        return buildPhotosList(resourceService.getPhotoConfEvent2011Url(),NB_PHOTOS_MAX);
    }

    private List<String> buildPhotosList(String baseUrl, int max) {
        List<String> photos = new ArrayList<String>();

        for (int i = 0; i < max; i++) {
            photos.add(baseUrl + "/" + formatFileName(i, NB_DIGIT) + PHOTO_EXT);
        }

        return photos;
    }

    private String formatFileName(final int indice, final int nbDigit) {
        String formattedFileName = String.valueOf(indice);
        while(formattedFileName.length() < nbDigit) formattedFileName = "0" + formattedFileName;
        return formattedFileName;
    }

    /**
     * @return images location for university
     */
    public List<String> getImagesUniversity() {
        return buildPhotosList(resourceService.getPhotoUnivEvent2011Url(),NB_PHOTOS_MAX);

    }


	public String getImageConference() {
		return "https://lh3.googleusercontent.com/-VDSRjJXi_W0/TnG04Q1UgBI/AAAAAAAACzk/v_ABAZaCZU8/w373-h279-n-k/IMG_0829.JPG";
	}

	public String getImageUniversity() {
		return "https://lh3.googleusercontent.com/-vnTHYTPdJqg/TnQ7X9SDuNI/AAAAAAAADKU/JlPmJHwwpsM/w373-h249-n-k/DSC_0233.JPG";

	}

}
