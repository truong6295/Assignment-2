package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.Student_Tests_TakenRepository;
import com.example.demo.entity.Student_Tests_Taken;
@Service
public class Student_Tets_TakenService {
	@Autowired
	private Student_Tests_TakenRepository studentTestTakenRepository;
	//add studentTestTaken
	public Student_Tests_Taken add(Date dateTestTaken,String otherDetails,String testResult,int registrationId) {
		Student_Tests_Taken studentTestsTakens=new Student_Tests_Taken();
		studentTestsTakens.setDateTestTaken(dateTestTaken);
		studentTestsTakens.setOtherDetails(otherDetails);
		studentTestsTakens.setTestResult(testResult);
		studentTestsTakens.setStudentCourseEnrolment(studentTestTakenRepository.findByPrimaryKeyStudentCourseEnrolmentRegistrationId(registrationId).getStudentCourseEnrolment());
		if(studentTestTakenRepository.save(studentTestsTakens) != null)
			return studentTestsTakens;
		return null;
	}
	
	//update studentTestTaken
	public Student_Tests_Taken update(int id,Date dateTestTaken,String otherDetailsTest,String testResult) {
		Student_Tests_Taken studentTestTaken =new Student_Tests_Taken();
		studentTestTaken.setDateTestTaken(dateTestTaken);
		studentTestTaken.setOtherDetails(otherDetailsTest);
		studentTestTaken.setTestResult(testResult);
		studentTestTaken.setStudentCourseEnrolment(studentTestTakenRepository.getOne(id).getStudentCourseEnrolment());
		if(studentTestTakenRepository.save(studentTestTaken) != null)
			return studentTestTaken;
		return null;
	}
	//delete studentTestTaken
	public boolean delete(int id) {
		if(studentTestTakenRepository.findByPrimaryKeyStudentCourseEnrolmentRegistrationId(id) != null) {				
			studentTestTakenRepository.delete(studentTestTakenRepository.findByPrimaryKeyStudentCourseEnrolmentRegistrationId(id));
			return true;
		}
		return false;
	}
	//view 
		public List<Student_Tests_Taken> viewAll(){
			List<Student_Tests_Taken> studentTestTakens= studentTestTakenRepository.findAll();
			return studentTestTakens;
		}
		//view 1 entity
		public Student_Tests_Taken viewId(int id) {
			Student_Tests_Taken studentTestTakens=studentTestTakenRepository.findByPrimaryKeyStudentCourseEnrolmentRegistrationId(id);
			return studentTestTakens;
		}
}
