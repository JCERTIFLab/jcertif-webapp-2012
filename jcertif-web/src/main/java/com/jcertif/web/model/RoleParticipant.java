package com.jcertif.web.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@XmlRootElement
public class RoleParticipant {

	/**
	 * Identifiant.
	 */
	private Long id;

	/**
	 * Code.
	 */
	private String code;

	/**
	 * Description.
	 */
	private String description;

	/**
	 * @return l'identifiant.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Définit un identifiant.
	 * 
	 * @param id
	 *            un identifiant
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return le code.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Définit le code de statut cedule.
	 * 
	 * @param code
	 *            un code de statut cedule
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return la description du statut cedule
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Définit la description.
	 * 
	 * @param description
	 *            une description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getCode()).toHashCode();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RoleParticipant)) {
			return false;
		}

		final RoleParticipant other = (RoleParticipant) obj;

		return new EqualsBuilder().append(getCode(), other.getCode()).isEquals();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return description;
	}

}
