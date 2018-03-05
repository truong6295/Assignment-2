package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;

import net.minidev.json.annotate.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the Student_Tests_Taken database table.
 * 
 */
@Entity
@NamedQuery(name="Student_Tests_Taken.findAll", query="SELECT s FROM Student_Tests_Taken s")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.studentCourseEnrolment",
        joinColumns = @JoinColumn(name = "registration_id")) })
public class Student_Tests_Taken implements Serializable {
	private static final long serialVersionUID = 1L;
	/*
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="registration_id")
	private int registrationId;
	*/
	
	private Student_Tests_TakenId primaryKey = new Student_Tests_TakenId();

	
	private Date dateTestTaken;

	
	private String otherDetails;

	
	private String testResult;

	//bi-directional one-to-one association to Student_Course_Enrolment
	//@ManyToOne
	//@JoinColumn(name="registration_id")
	//private Student_Course_Enrolment studentCourseEnrolment;

	public Student_Tests_Taken() {
	}
	
	@EmbeddedId
	public Student_Tests_TakenId getPrimaryKey() {
		return this.primaryKey;
	}

	public void setPrimaryKey(Student_Tests_TakenId primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_test_taken")
	public Date getDateTestTaken() {
		return this.dateTestTaken;
	}

	public void setDateTestTaken(Date dateTestTaken) {
		this.dateTestTaken = dateTestTaken;
	}
	@Column(name="other_details")
	public String getOtherDetails() {
		return this.otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}
	@Column(name="test_result")
	public String getTestResult() {
		return this.testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}
	@Transient
	
	public Student_Course_Enrolment getStudentCourseEnrolment() {
		return getPrimaryKey().getStudentCourseEnrolment();
	}

	public void setStudentCourseEnrolment(Student_Course_Enrolment studentCourseEnrolment) {
		getPrimaryKey().setStudentCourseEnrolment(studentCourseEnrolment);
	}
	

}