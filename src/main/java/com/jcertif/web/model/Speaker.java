package com.jcertif.web.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe Speaker
 * 
 * @author Mamadou
 * 
 */
@XmlRootElement
public class Speaker {

	private Long id;

	private String prenom;

	private String nom;

	private String photo;

	private String bio;

	private String compagnie;

	public Speaker() {
	}

	public Speaker(User user) {
		prenom = user.getPrenom();
		nom = user.getNom();
		photo = user.getPhoto();
		compagnie = user.getCompagnie();
		bio = user.getBio();
	}

	/**
	 * @return the compagnie
	 */
	public String getCompagnie() {
		return compagnie;
	}

	/**
	 * @param compagnie
	 *            the compagnie to set
	 */
	public void setCompagnie(String compagnie) {
		this.compagnie = compagnie;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo
	 *            the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the bio
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * @param bio
	 *            the bio to set
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}

}
