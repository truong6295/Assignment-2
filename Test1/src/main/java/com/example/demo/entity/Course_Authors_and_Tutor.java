package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;


/**
 * The persistent class for the Course_Authors_and_Tutors database table.
 * 
 */
@Entity
@Table(name="Course_Authors_and_Tutors")
@NamedQuery(name="Course_Authors_and_Tutor.findAll", query="SELECT c FROM Course_Authors_and_Tutor c")
public class Course_Authors_and_Tutor implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int authorId;

	
	private String addressLine1;

	
	private String addressLine2;

	
	private String addressLine3;

	private String author_tutor_ATB;

	
	private String familyName;

	
	private String genderMf;

	
	private String loginName;

	
	private String middleName;

	
	private String otherDetails;

	private String password;

	
	private String personalName;

	//bi-directional many-to-one association to Cours
	
	private Set<Cours> courses;

	public Course_Authors_and_Tutor() {
	}
	public Course_Authors_and_Tutor(String addressLine1,String addressLine2,String addressLine3,String author_tutor_ATB,String familyName,String genderMf,String loginName,String middleName,String otherDetails,String password,String personalName) {
		this.addressLine1=addressLine1;
		this.addressLine2=addressLine2;
		this.addressLine3=addressLine3;
		this.author_tutor_ATB=author_tutor_ATB;
		this.familyName=familyName;
		this.genderMf=genderMf;
		this.loginName=loginName;
		this.middleName=middleName;
		this.otherDetails=otherDetails;
		this.password=password;
		this.personalName=personalName;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="author_id")
	public int getAuthorId() {
		return this.authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	@Column(name="address_line_1")
	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	@Column(name="address_line_2")
	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	@Column(name="address_line_3")
	public String getAddressLine3() {
		return this.addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getAuthor_tutor_ATB() {
		return this.author_tutor_ATB;
	}

	public void setAuthor_tutor_ATB(String author_tutor_ATB) {
		this.author_tutor_ATB = author_tutor_ATB;
	}
	@Column(name="family_name")
	public String getFamilyName() {
		return this.familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	@Column(name="gender_mf")
	public String getGenderMf() {
		return this.genderMf;
	}

	public void setGenderMf(String genderMf) {
		this.genderMf = genderMf;
	}
	@Column(name="login_name")
	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	@Column(name="middle_name")
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	@Column(name="other_details")
	public String getOtherDetails() {
		return this.otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="personal_name")
	public String getPersonalName() {
		return this.personalName;
	}

	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}
	@OneToMany(mappedBy="courseAuthorsAndTutor", fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonIgnore
	public Set<Cours> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Cours> courses) {
		this.courses = courses;
	}

	public Cours addCours(Cours cours) {
		getCourses().add(cours);
		cours.setCourseAuthorsAndTutor(this);

		return cours;
	}

	public Cours removeCours(Cours cours) {
		getCourses().remove(cours);
		cours.setCourseAuthorsAndTutor(null);

		return cours;
	}

}