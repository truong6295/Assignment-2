package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseRepository;
import com.example.demo.dao.StudentRepository;
import com.example.demo.dao.Student_Course_EnrolmentRepository;
import com.example.demo.entity.Cours;
import com.example.demo.entity.Student;
import com.example.demo.entity.Student_Course_Enrolment;
@Service
public class Student_Course_EnrolmentService {
	@Autowired
	private Student_Course_EnrolmentRepository studentCourseEnrolmentRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;
	//add
	public Student_Course_Enrolment add(Date dateOfCompletion,Date dateOfEnrolment,String otherDetails,
			int studentId,int courseId) {
		Student_Course_Enrolment studentCourseEnrolment=new Student_Course_Enrolment(dateOfCompletion, dateOfEnrolment, otherDetails,
				studentRepository.getOne(studentId), courseRepository.getOne(courseId));
		if(studentCourseEnrolmentRepository.save(studentCourseEnrolment) != null)
			return studentCourseEnrolment;
		return null;
	}
	
	//update
	public Student_Course_Enrolment update(int id,Date dateOfCompletion,Date dateOfEnrolment,String otherDetails,int studentId,int courseId) {
		Student_Course_Enrolment studentCourseEnrolment=new Student_Course_Enrolment(dateOfCompletion, dateOfEnrolment, otherDetails, 
				studentRepository.getOne(studentId), courseRepository.getOne(courseId));
		studentCourseEnrolment.setRegistrationId(id);
		if(studentCourseEnrolmentRepository.save(studentCourseEnrolment) != null)
			return studentCourseEnrolment;
		return null;
	}
	
	//delete
	public boolean delete(int id) {
		Student_Course_Enrolment studentCourseEnrolments=studentCourseEnrolmentRepository.getOne(id);
		studentCourseEnrolments.setRegistrationId(id);
		if(studentCourseEnrolmentRepository.exists(id)) {
			
			studentCourseEnrolmentRepository.delete(studentCourseEnrolments);
			return true;
		}
		return false;
	}
	//view 
		public List<Student_Course_Enrolment> viewAll(){
			List<Student_Course_Enrolment> studentCourseEnrolments= studentCourseEnrolmentRepository.findAll();
			return studentCourseEnrolments;
		}
		//view 1 entity
		public Student_Course_Enrolment viewId(int id) {
			Student_Course_Enrolment studentCourseEnrolments=studentCourseEnrolmentRepository.findOne(id);
			return studentCourseEnrolments;
		}
}
