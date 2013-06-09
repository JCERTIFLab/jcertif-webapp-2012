package com.jcertif.web.model;

import org.primefaces.model.UploadedFile;

import java.io.Serializable;

public class Warid implements Serializable {

	private String groupName;
	private String projectName;
	private String leadLastName;
	private String leadFirstName;
	private String phone;
	private String email;
	private UploadedFile file;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getLeadLastName() {
		return leadLastName;
	}

	public void setLeadLastName(String leadLastName) {
		this.leadLastName = leadLastName;
	}

	public String getLeadFirstName() {
		return leadFirstName;
	}

	public void setLeadFirstName(String leadFirstName) {
		this.leadFirstName = leadFirstName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Warid [groupName=" + groupName + ", projectName=" + projectName
				+ ", leadLastName=" + leadLastName + ", leadFirstName="
				+ leadFirstName + ", phone=" + phone + ", email=" + email
				+ ", file=" + file + "]";
	}

}
