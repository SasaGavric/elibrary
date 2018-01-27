package com.sasagavric.spring.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "member")
public class Member extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth")
	@DateTimeFormat(iso= ISO.DATE)
	@NotNull
	@Past(message = "invalid date")
	private Date dateOfBirth;

	@Column(name = "adress")
	@NotNull
	@Size(min = 2, max = 80)
	private String adress;

	@Column(name = "city")
	@NotNull
	@Size(min = 2, max = 80)
	private String city;

	@Column(name = "phone")
	@Size(min = 2, max = 35)
	@NotNull
	private String phone;

	@Column(name = "email")
	@Email
	private String email;
	
	@Column(name="image_url")
	private String profileImageUrl;

	//default constructor
	public Member() {

	}

	//accessors and mutators
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}
	
	

}
