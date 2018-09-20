package com.firekernel.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.firekernel.demo.util.Utils;

@Entity
@Table(name = "user", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "email", "contact_number", "fb_id", "google_id" }) })
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "created_at", "updated_at" }, allowGetters = true)
public class User extends BaseModel {
	private static final long serialVersionUID = 6081253945216194212L;

	@Column(name = "password")
	private String password;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "birthday")
	private String birthday;

	@Column(name = "gender")
	private String gender;

	@Column(name = "avatar")
	private String avatar;

	@Column(name = "email")
	private String email;

	@Column(name = "contact_number")
	private String contactNumber;

	@Column(name = "fb_id")
	private String fbId;

	@Column(name = "google_id")
	private String googleId;

	@Column(name = "last_login")
	private String lastLogin;

	@Column(name = "token")
	private String token;

	@JsonIgnore
	@Column(name = "is_active")
	private Boolean isActive;

	@JsonIgnore
	@Column(name = "is_staff")
	private Boolean isStaff;

	@JsonIgnore
	@Column(name = "is_superuser")
	private Boolean isSuperuser;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (Utils.isEmpty(password))
			return;
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (Utils.isEmpty(lastName))
			return;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (Utils.isEmpty(firstName))
			return;
		this.firstName = firstName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		if (Utils.isEmpty(birthday))
			return;
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		if (Utils.isEmpty(gender))
			return;
		this.gender = gender;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		if (Utils.isEmpty(avatar))
			return;
		this.avatar = avatar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (Utils.isEmpty(email))
			return;
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		if (Utils.isEmpty(contactNumber))
			return;
		this.contactNumber = contactNumber;
	}

	public String getFbId() {
		return fbId;
	}

	public void setFbId(String fbId) {
		if (Utils.isEmpty(fbId))
			return;
		this.fbId = fbId;
	}

	public String getGoogleId() {
		return googleId;
	}

	public void setGoogleId(String googleId) {
		if (Utils.isEmpty(googleId))
			return;
		this.googleId = googleId;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsStaff() {
		return isStaff;
	}

	public void setIsStaff(Boolean isStaff) {
		this.isStaff = isStaff;
	}

	public Boolean getIsSuperuser() {
		return isSuperuser;
	}

	public void setIsSuperuser(Boolean isSuperuser) {
		this.isSuperuser = isSuperuser;
	}

}
