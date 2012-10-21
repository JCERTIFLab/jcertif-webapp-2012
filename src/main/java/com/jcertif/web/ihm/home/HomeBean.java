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
        return buildPhotosList(resourceService.getPhotoConfEvent2011Url(), NB_PHOTOS_MAX);
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
        while (formattedFileName.length() < nbDigit) {
            formattedFileName = "0" + formattedFileName;
        }
        return formattedFileName;
    }

    /**
     * @return images location for university
     */
    public List<String> getImagesUniversity() {
        return buildPhotosList(resourceService.getPhotoUnivEvent2011Url(), NB_PHOTOS_MAX);

    }

    public List<String> getImages2012() {
        List<String> images = new ArrayList<String>();
        images.add("https://lh6.googleusercontent.com/-Zj1JcJtP4RY/UHP1R5feaRI/AAAAAAAABNg/q7ZURF0VI74/s953/DSC_0146.JPG");
        images.add("https://lh3.googleusercontent.com/-UL4pE4Fb9Zs/UHP3EzHbA3I/AAAAAAAABdA/0Hhp3o_5qh4/s953/DSC_0272.JPG");
        images.add("https://lh3.googleusercontent.com/-ziuEYkJBPOw/UFqPrWn-PrI/AAAAAAAAAb8/_KgGJU9n-Bg/s953/DSC_0029.jpg");
        images.add("https://lh4.googleusercontent.com/-VTCJjITXxAQ/UFqPrSOrUTI/AAAAAAAAAb8/LUGd7ORh75Q/s953/DSC_0260_1.jpg");

        images.add("https://lh4.googleusercontent.com/-TAFhAN3_qvU/UFqPrUtPg6I/AAAAAAAAAb8/92A7rrQB1Q0/s953/DSC_0268.jpg");
        images.add("https://lh5.googleusercontent.com/-q4FDrA2eoY8/UFqPrWK04pI/AAAAAAAAAb8/U35Mpt9imlM/s953/DSC_0308.jpg");
        images.add("https://lh3.googleusercontent.com/-BKWtENQKpgs/UFqPrd2CICI/AAAAAAAAAb8/6ADSA4ftto0/s953/DSC_0313.jpg");
        images.add("https://lh3.googleusercontent.com/-cPPrzkhqTFs/UFqPrVDWhmI/AAAAAAAAAb8/AyRGsdI8mTg/s953/DSC_0059_2.jpg");
        images.add("https://lh4.googleusercontent.com/-FS9Cb1RH91A/UFqPrXtx0YI/AAAAAAAAAb8/mDMLrfHKebw/s1068/KimiaSolution.jpg");
        images.add("https://lh3.googleusercontent.com/-dqfy29lDWjA/UFqPrdcqsNI/AAAAAAAAAb8/oevWLnsgbNU/s953/TVshow4.jpg");

        return images;

    }

    public String getImageConference() {
        return "https://lh3.googleusercontent.com/-VDSRjJXi_W0/TnG04Q1UgBI/AAAAAAAACzk/v_ABAZaCZU8/w373-h279-n-k/IMG_0829.JPG";
    }

    public String getImageUniversity() {
        return "https://lh3.googleusercontent.com/-vnTHYTPdJqg/TnQ7X9SDuNI/AAAAAAAADKU/JlPmJHwwpsM/w373-h249-n-k/DSC_0233.JPG";

    }
}
