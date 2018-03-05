package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the Student_Course_Enrolment database table.
 * 
 */
@Entity
@NamedQuery(name="Student_Course_Enrolment.findAll", query="SELECT s FROM Student_Course_Enrolment s")
public class Student_Course_Enrolment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="registration_id")
	private int registrationId;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_completion")
	private Date dateOfCompletion;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_enrolment")
	private Date dateOfEnrolment;

	@Column(name="other_details")
	private String otherDetails;

	//bi-directional many-to-one association to Student
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="student_id")
	private Student student;

	//bi-directional many-to-one association to Cours
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="course_id")
	private Cours cours;

	//bi-directional one-to-many association to Student_Tests_Taken
	@OneToMany(mappedBy="primaryKey.studentCourseEnrolment",cascade = CascadeType.ALL)
	private Set<Student_Tests_Taken> studentTestsTaken= new HashSet<Student_Tests_Taken>();

	public Student_Course_Enrolment() {
	}
	public Student_Course_Enrolment(Date dateOfCompletion,Date dateOfEnrolment,String otherDetails,Student student,Cours cours) {
		this.dateOfCompletion=dateOfCompletion;
		this.dateOfEnrolment=dateOfEnrolment;
		this.otherDetails=otherDetails;
		this.student=student;
		this.cours=cours;
	}
	public int getRegistrationId() {
		return this.registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public Date getDateOfCompletion() {
		return this.dateOfCompletion;
	}

	public void setDateOfCompletion(Date dateOfCompletion) {
		this.dateOfCompletion = dateOfCompletion;
	}

	public Date getDateOfEnrolment() {
		return this.dateOfEnrolment;
	}

	public void setDateOfEnrolment(Date dateOfEnrolment) {
		this.dateOfEnrolment = dateOfEnrolment;
	}

	public String getOtherDetails() {
		return this.otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}
	
	
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Cours getCours() {
		return this.cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}
//	@JsonBackReference
	@JsonIgnore
	public Set<Student_Tests_Taken> getStudentTestsTaken() {
		return studentTestsTaken;
	}

	public void setStudentTestsTaken(Set<Student_Tests_Taken> studentTestsTaken) {
		this.studentTestsTaken = studentTestsTaken;
	}
	public void addStudentTestsTaken(Student_Tests_Taken studentTestsTaken) {
        this.studentTestsTaken.add( studentTestsTaken);
    }

}