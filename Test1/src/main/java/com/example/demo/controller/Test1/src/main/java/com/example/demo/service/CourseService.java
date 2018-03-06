package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseRepository;
import com.example.demo.dao.Course_Authors_and_TutorRepository;
import com.example.demo.dao.SubjectRepository;
import com.example.demo.entity.Cours;
import com.example.demo.entity.Course_Authors_and_Tutor;
import com.example.demo.entity.Subject;
@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private Course_Authors_and_TutorRepository courseAuthorsAndTutorRepository;
	//add 
	public Cours add(String courseDescription,String courseName,String otherDetails,int subjectId,int courseAuthorsAndTutorId) {
		Cours course=new Cours(courseDescription, courseName, otherDetails, subjectRepository.getOne(subjectId), courseAuthorsAndTutorRepository.getOne(courseAuthorsAndTutorId));
		if(courseRepository.save(course)!=null)
			return course;
		return null;	
	}
	// update
	public Cours update(int id,String courseDescription,String courseName,String otherDetails,int subjectId,int courseAuthorsAndTutorId) {
		Cours course=new Cours(courseDescription, courseName, otherDetails, subjectRepository.getOne(subjectId), courseAuthorsAndTutorRepository.getOne(courseAuthorsAndTutorId));
		course.setCourseId(id);
		if(courseRepository.save(course)!=null)
			return course;
		return null;	
	}
	// delete
	public boolean delete(Integer id) {
		
		if(courseRepository.exists(id)) {
			courseRepository.delete(id);
			return true;
		}
		return false;
	}
	//view all
	public List<Cours> viewAll(){
		List<Cours> courses=courseRepository.findAll();
		return courses;
	}
	//view 1 entity
	public Cours viewId(int id) {
		if(courseRepository.findOne(id)!=null)
			return courseRepository.findOne(id);
		else
			return null;
	}
}
