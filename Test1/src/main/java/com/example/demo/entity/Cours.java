package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;


/**
 * The persistent class for the Courses database table.
 * 
 */
@Entity
@Table(name="Courses")
@NamedQuery(name="Cours.findAll", query="SELECT c FROM Cours c")
public class Cours implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_id")
	private int courseId;

	@Column(name="course_description")
	private String courseDescription;

	@Column(name="course_name")
	private String courseName;

	@Column(name="other_details")
	private String otherDetails;

	//bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name="subject_id")
	private Subject subject;

	//bi-directional many-to-one association to Course_Authors_and_Tutor
	@ManyToOne
	@JoinColumn(name="author_id")
	private Course_Authors_and_Tutor courseAuthorsAndTutor;

	//bi-directional many-to-one association to Student_Course_Enrolment
	@OneToMany(mappedBy="cours", fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<Student_Course_Enrolment> studentCourseEnrolments;

	public Cours() {
	}
	public Cours(String courseDescription,String courseName,String otherDetails,Subject subject,Course_Authors_and_Tutor courseAuthorsAndTutor) {
		this.courseDescription=courseDescription;
		this.courseName=courseName;
		this.otherDetails=otherDetails;
		this.subject=subject;
		this.courseAuthorsAndTutor=courseAuthorsAndTutor;
	}
	public int getCourseId() {
		return this.courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseDescription() {
		return this.courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getOtherDetails() {
		return this.otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}
	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Course_Authors_and_Tutor getCourseAuthorsAndTutor() {
		return this.courseAuthorsAndTutor;
	}

	public void setCourseAuthorsAndTutor(Course_Authors_and_Tutor courseAuthorsAndTutor) {
		this.courseAuthorsAndTutor = courseAuthorsAndTutor;
	}
	@JsonIgnore
	public Set<Student_Course_Enrolment> getStudentCourseEnrolments() {
		return this.studentCourseEnrolments;
	}

	public void setStudentCourseEnrolments(Set<Student_Course_Enrolment> studentCourseEnrolments) {
		this.studentCourseEnrolments = studentCourseEnrolments;
	}

	public Student_Course_Enrolment addStudentCourseEnrolment(Student_Course_Enrolment studentCourseEnrolment) {
		getStudentCourseEnrolments().add(studentCourseEnrolment);
		studentCourseEnrolment.setCours(this);

		return studentCourseEnrolment;
	}

	public Student_Course_Enrolment removeStudentCourseEnrolment(Student_Course_Enrolment studentCourseEnrolment) {
		getStudentCourseEnrolments().remove(studentCourseEnrolment);
		studentCourseEnrolment.setCours(null);

		return studentCourseEnrolment;
	}

}