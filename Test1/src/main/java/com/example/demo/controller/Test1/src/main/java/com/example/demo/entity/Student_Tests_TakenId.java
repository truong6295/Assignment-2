package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class Student_Tests_TakenId implements Serializable{
	private static final long serialVersionUID = 1L;
	private Student_Course_Enrolment studentCourseEnrolment;
	
	@ManyToOne(cascade = CascadeType.ALL)
    public Student_Course_Enrolment getStudentCourseEnrolment(){
        return studentCourseEnrolment;
    }
 
    public void setStudentCourseEnrolment(Student_Course_Enrolment studentCourseEnrolment) {
        this.studentCourseEnrolment = studentCourseEnrolment;
    }
    
}
