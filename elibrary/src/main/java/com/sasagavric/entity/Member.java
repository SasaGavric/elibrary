package com.sasagavric.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Sasa Gavric
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@Entity
public class Member extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth")
	@DateTimeFormat(iso= ISO.DATE)
	@NotNull
	@Past
	private Date dateOfBirth;

	@NotNull
	@Size(min = 2, max = 80)
	private String adress;

	@NotNull
	@Size(min = 2, max = 80)
	private String city;

	@Size(min = 2, max = 35)
	@NotNull
	private String phone;

	@Email
	private String email;
	
	@Column(name="image_url")
	private String profileImageUrl;
	
	@OneToMany(mappedBy="member", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.EAGER)
	private List<BorrowedBook> borrowedBooks = new ArrayList<>();

}
