package com.jcertif.web.model;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;

import java.io.Serializable;

/**
 * 
 * @author rossi.oddet
 * 
 */
@XmlRootElement
public class User implements Serializable {

	private Long id;
	private String civilite;
	private String nom;
	@Size(min = 1)
	private String prenom;
	@Email
	private String email;
	@Email
	private String confirmemail;
	private String passwd;
	private String confirmpasswd;
	private String photo;
	private String role;
	private String typeUser;
	private String compagnie;
	private String siteWeb;
	private String telFixe;
	private String telMobile;
	private String ville;
	private String pays;
	private Long idConference;
	private String bio;

	public User() {
		super();
	}

	public Long getId() {
		return id;
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

	public void setId(Long id) {
		this.id = id;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

	public String getCompagnie() {
		return compagnie;
	}

	public void setCompagnie(String compagnie) {
		this.compagnie = compagnie;
	}

	public String getSiteWeb() {
		return siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	public String getTelFixe() {
		return telFixe;
	}

	public void setTelFixe(String telFixe) {
		this.telFixe = telFixe;
	}

	public String getTelMobile() {
		return telMobile;
	}

	public void setTelMobile(String telMobile) {
		this.telMobile = telMobile;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	/**
	 * @return the confirmemail
	 */
	public String getConfirmemail() {
		return confirmemail;
	}

	/**
	 * @param confirmemail
	 *            the confirmemail to set
	 */
	public void setConfirmemail(String confirmemail) {
		this.confirmemail = confirmemail;
	}

	/**
	 * @return the confirmpasswd
	 */
	public String getConfirmpasswd() {
		return confirmpasswd;
	}

	/**
	 * @param confirmpasswd
	 *            the confirmpasswd to set
	 */
	public void setConfirmpasswd(String confirmpasswd) {
		this.confirmpasswd = confirmpasswd;
	}

	/**
	 * @return the idConference
	 */
	public Long getIdConference() {
		return idConference;
	}

	/**
	 * @param idConference
	 *            the idConference to set
	 */
	public void setIdConference(Long idConference) {
		this.idConference = idConference;
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
