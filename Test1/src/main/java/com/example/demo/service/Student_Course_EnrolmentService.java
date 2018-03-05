package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Student_Course_EnrolmentRepository;
import com.example.demo.dao.Student_Tests_TakenRepository;
import com.example.demo.entity.Cours;
import com.example.demo.entity.Student;
import com.example.demo.entity.Student_Course_Enrolment;
import com.example.demo.entity.Student_Tests_Taken;
@Service
public class Student_Course_EnrolmentService {
	@Autowired
	private Student_Course_EnrolmentRepository studentCourseEnrolmentRepository;
	@Autowired
	private Student_Tests_TakenRepository studentTestTakenRepository;
	//add
	public Student_Course_Enrolment add(Date dateOfCompletion,Date dateOfEnrolment,String otherDetails,Student student,Cours cours) {
		Student_Course_Enrolment studentCourseEnrolment=new Student_Course_Enrolment(dateOfCompletion, dateOfEnrolment, otherDetails, student, cours);
		if(studentCourseEnrolmentRepository.save(studentCourseEnrolment) != null)
			return studentCourseEnrolment;
		return null;
	}
	//add studentTestTaken
	public boolean add(Date dateOfCompletion,Date dateOfEnrolment,String otherDetails,Student student,Cours cours,Date dateTestTaken,String otherDetailsTest,String testResult) {
		Student_Course_Enrolment studentCourseEnrolment=new Student_Course_Enrolment(dateOfCompletion, dateOfEnrolment, otherDetails, student, cours);
		Student_Tests_Taken studentTestTaken =new Student_Tests_Taken();
		studentTestTaken.setDateTestTaken(dateTestTaken);
		studentTestTaken.setOtherDetails(otherDetailsTest);
		studentTestTaken.setTestResult(testResult);
		studentTestTaken.setStudentCourseEnrolment(studentCourseEnrolment);
		studentCourseEnrolment.addStudentTestsTaken(studentTestTaken);
		if(studentCourseEnrolmentRepository.save(studentCourseEnrolment) != null)
			return true;
		return false;
	}
	//update
	public boolean update(int id,Date dateOfCompletion,Date dateOfEnrolment,String otherDetails,Student student,Cours cours) {
		Student_Course_Enrolment studentCourseEnrolment=new Student_Course_Enrolment(dateOfCompletion, dateOfEnrolment, otherDetails, student, cours);
		studentCourseEnrolment.setRegistrationId(id);
		if(studentCourseEnrolmentRepository.save(studentCourseEnrolment) != null)
			return true;
		return false;
	}
	//update studentTestTaken
	public boolean update(int id,Date dateTestTaken,String otherDetailsTest,String testResult) {
		Student_Tests_Taken studentTestTaken =new Student_Tests_Taken();
		studentTestTaken.setDateTestTaken(dateTestTaken);
		studentTestTaken.setOtherDetails(otherDetailsTest);
		studentTestTaken.setTestResult(testResult);
		studentTestTaken.setStudentCourseEnrolment(studentCourseEnrolmentRepository.getOne(id));
		if(studentCourseEnrolmentRepository.save(studentCourseEnrolmentRepository.getOne(id)) != null)
			return true;
		return false;
	}
	//delete
	public boolean delete(int id) {
		if(studentCourseEnrolmentRepository.exists(id)) {
			studentCourseEnrolmentRepository.delete(id);
			return true;
		}
		return false;
	}
	
}
