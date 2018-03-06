package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the Students database table.
 * 
 */
@Entity
@Table(name="Students")
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
@Proxy(lazy=false)
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int studentId;

	
	private Date dateOfLatestLogon;

	
	private Date dateOfRegistration;

	
	private String familyName;

	
	private String loginName;

	
	private String middleName;

	
	private String otherDetails;

	private String password;

	
	private String personalName;

	//bi-directional many-to-one association to Student_Course_Enrolment
	
	private Set<Student_Course_Enrolment> studentCourseEnrolments;

	public Student() {
	}
	public Student(Date dateOfLatestLogon,Date dateOfRegistration,String familyName,String loginName,String middleName,String otherDetails,String password,String personalName) {
		this.dateOfLatestLogon=dateOfLatestLogon;
		this.dateOfRegistration=dateOfRegistration;
		this.familyName=familyName;
		this.loginName=loginName;
		this.middleName=middleName;
		this.otherDetails=otherDetails;
		this.password=password;
		this.personalName=personalName;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	public int getStudentId() {
		return this.studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_latest_logon")
	public Date getDateOfLatestLogon() {
		return this.dateOfLatestLogon;
	}

	public void setDateOfLatestLogon(Date dateOfLatestLogon) {
		this.dateOfLatestLogon = dateOfLatestLogon;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_registration")
	public Date getDateOfRegistration() {
		return this.dateOfRegistration;
	}

	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}
	@Column(name="family_name")
	public String getFamilyName() {
		return this.familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
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
	@OneToMany(mappedBy="student", fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonIgnore
	public Set<Student_Course_Enrolment> getStudentCourseEnrolments() {
		return this.studentCourseEnrolments;
	}

	public void setStudentCourseEnrolments(Set<Student_Course_Enrolment> studentCourseEnrolments) {
		this.studentCourseEnrolments = studentCourseEnrolments;
	}

	public Student_Course_Enrolment addStudentCourseEnrolment(Student_Course_Enrolment studentCourseEnrolment) {
		getStudentCourseEnrolments().add(studentCourseEnrolment);
		studentCourseEnrolment.setStudent(this);

		return studentCourseEnrolment;
	}

	public Student_Course_Enrolment removeStudentCourseEnrolment(Student_Course_Enrolment studentCourseEnrolment) {
		getStudentCourseEnrolments().remove(studentCourseEnrolment);
		studentCourseEnrolment.setStudent(null);

		return studentCourseEnrolment;
	}

}