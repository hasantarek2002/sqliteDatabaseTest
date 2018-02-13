package facebook;

import javax.swing.JLabel;

public class Information {
	private String firstName, surName, email, reEnteredEmail, newPassword, birthday, age,isAdmin;

	public Information(String firstName, String surName, String email,
			String reEnteredEmail, String newPassword, String birthday, String age,String isAdmin) {
		this.email = email;
		this.firstName = firstName;
		this.surName = surName;
		this.email = email;
		this.reEnteredEmail = reEnteredEmail;
		this.newPassword = newPassword;
		this.birthday = birthday;
		this.age = age;
		this.isAdmin=isAdmin;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReEnteredEmail() {
		return reEnteredEmail;
	}

	public void setReEnteredEmail(String reEnteredEmail) {
		this.reEnteredEmail = reEnteredEmail;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	

	

	
	

}
