package com.ayawala.venus.models.db.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER_ACCOUNT")
public class UserAccount {

	@Id
	private Long userProfileId;
	
	private Long userAccountStatusId;
	
	@Column(unique = true, length = 254)
	@Size(max = 254)
	private String username;
	
	@Column(length = 254)
	@Size(max = 254)
	private String email;
	
	private String password;
	
	private Long passwordSalt;
	
	private String passwordHashAlgorithm;
	
	private String passwordReminderToken;
	
	private String passwordReminderExpire;
	
	private String emailConfirmationToken;

	// Constructors
	public UserAccount() {
	}
	
	public UserAccount(final String username, final String email) {
		this.username = username;
		this.email = email;
	}

	// Getters and Setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(Long passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	public String getPasswordHashAlgorithm() {
		return passwordHashAlgorithm;
	}

	public void setPasswordHashAlgorithm(String passwordHashAlgorithm) {
		this.passwordHashAlgorithm = passwordHashAlgorithm;
	}

	public String getPasswordReminderToken() {
		return passwordReminderToken;
	}

	public void setPasswordReminderToken(String passwordReminderToken) {
		this.passwordReminderToken = passwordReminderToken;
	}

	public String getPasswordReminderExpire() {
		return passwordReminderExpire;
	}

	public void setPasswordReminderExpire(String passwordReminderExpire) {
		this.passwordReminderExpire = passwordReminderExpire;
	}

	public String getEmailConfirmationToken() {
		return emailConfirmationToken;
	}

	public void setEmailConfirmationToken(String emailConfirmationToken) {
		this.emailConfirmationToken = emailConfirmationToken;
	}

	public Long getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(Long userProfileId) {
		this.userProfileId = userProfileId;
	}

	public Long getUserAccountStatusId() {
		return userAccountStatusId;
	}

	public void setUserAccountStatusId(Long userAccountStatusId) {
		this.userAccountStatusId = userAccountStatusId;
	}
}
