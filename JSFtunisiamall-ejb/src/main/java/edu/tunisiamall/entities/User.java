package edu.tunisiamall.entities;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;

@Entity
@DiscriminatorColumn(name = "USER_TYPE")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;

	private String address;

	@Temporal(TemporalType.TIMESTAMP)
	private Date birthdate;

	private String firstName;

	private String gender;

	private String job;

	private String lastName;

	private String login;

	private String mail;

	private String password;

	private String phone;

	private String pictureUrl;

	private Boolean baned;

	public Boolean getBaned() {
		return baned;
	}

	public User(String address, Date birthdate, String firstName, String gender, String job, String lastName,
			String login, String mail, String password, String phone, String pictureUrl) {
		super();
		this.address = address;
		this.birthdate = birthdate;
		this.firstName = firstName;
		this.gender = gender;
		this.job = job;
		this.lastName = lastName;
		this.login = login;
		this.mail = mail;
		this.password = password;
		this.phone = phone;
		this.pictureUrl = pictureUrl;
	}

	public void setBaned(Boolean baned) {
		this.baned = baned;
	}

	public User() {
		super();
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return idUser;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

}