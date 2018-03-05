package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Student_Course_EnrolmentRepository;
import com.example.demo.dao.Student_Tests_TakenRepository;
import com.example.demo.entity.Student_Tests_Taken;
@Service
public class Student_Tets_TakenService {
	@Autowired
	private Student_Tests_TakenRepository studentTestTakenRepository;
	@Autowired
	private Student_Course_EnrolmentRepository studentCourseEnrolmentRepository;
	//delete studentTestTaken
		public boolean delete(int id) {
			if(studentTestTakenRepository.findByPrimaryKeyStudentCourseEnrolmentRegistrationId(id) != null) {
				
				studentTestTakenRepository.delete(studentTestTakenRepository.findByPrimaryKeyStudentCourseEnrolmentRegistrationId(id));;
				return true;
			}
			return false;
		}
}
