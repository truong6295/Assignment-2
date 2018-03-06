package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Course_Authors_and_TutorRepository;
import com.example.demo.entity.Course_Authors_and_Tutor;
@Service
public class Course_Authors_and_TutorService {
	@Autowired
	private Course_Authors_and_TutorRepository CAATRepository;
	//add 
	public Course_Authors_and_Tutor add(String addressLine1,String addressLine2,String addressLine3,
			String author_tutor_ATB,String familyName,String genderMf,String loginName,
			String middleName,String otherDetails,String password,String personalName) {
		Course_Authors_and_Tutor courseAuthorsAndTutor =new Course_Authors_and_Tutor(addressLine1, addressLine2, addressLine3, author_tutor_ATB, familyName, genderMf, loginName, middleName, otherDetails, password, personalName);
		if(CAATRepository.save(courseAuthorsAndTutor) != null)
			return courseAuthorsAndTutor;
		return null;
	}
	//update
	public Course_Authors_and_Tutor update(int id,String addressLine1,String addressLine2,String addressLine3,String author_tutor_ATB,String familyName,String genderMf,String loginName,String middleName,String otherDetails,String password,String personalName) {
		Course_Authors_and_Tutor courseAuthorsAndTutor =new Course_Authors_and_Tutor(addressLine1, addressLine2, addressLine3, author_tutor_ATB, familyName, genderMf, loginName, middleName, otherDetails, password, personalName);
		courseAuthorsAndTutor.setAuthorId(id);
		if(CAATRepository.save(courseAuthorsAndTutor) != null)
			return courseAuthorsAndTutor;
		return null;
	}
	//delete
	public boolean delete(int id) {
		if(CAATRepository.exists(id)) {
			CAATRepository.delete(id);
			return true;
		}
		return false;
	}
	//view 
		public List<Course_Authors_and_Tutor> viewAll(){
			List<Course_Authors_and_Tutor> courseAuthorsAndTutor= CAATRepository.findAll();
			return courseAuthorsAndTutor;
		}
		//view 1 entity
		public Course_Authors_and_Tutor viewId(int id) {
			Course_Authors_and_Tutor courseAuthorsAndTutor=CAATRepository.findOne(id);
			return courseAuthorsAndTutor;
		}
}
