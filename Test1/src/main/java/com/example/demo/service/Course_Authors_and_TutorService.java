package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Course_Authors_and_TutorRepository;
import com.example.demo.entity.Course_Authors_and_Tutor;
@Service
public class Course_Authors_and_TutorService {
	@Autowired
	private Course_Authors_and_TutorRepository CAATRepository;
	//add 
	public Course_Authors_and_Tutor add(String addressLine1,String addressLine2,String addressLine3,String author_tutor_ATB,String familyName,String genderMf,String loginName,String middleName,String otherDetails,String password,String personalName) {
		Course_Authors_and_Tutor courseAuthorsAndTutor =new Course_Authors_and_Tutor(addressLine1, addressLine2, addressLine3, author_tutor_ATB, familyName, genderMf, loginName, middleName, otherDetails, password, personalName);
		if(CAATRepository.save(courseAuthorsAndTutor) != null)
			return courseAuthorsAndTutor;
		return null;
	}
	//update
	public boolean update(int id,String addressLine1,String addressLine2,String addressLine3,String author_tutor_ATB,String familyName,String genderMf,String loginName,String middleName,String otherDetails,String password,String personalName) {
		Course_Authors_and_Tutor courseAuthorsAndTutor =new Course_Authors_and_Tutor(addressLine1, addressLine2, addressLine3, author_tutor_ATB, familyName, genderMf, loginName, middleName, otherDetails, password, personalName);
		courseAuthorsAndTutor.setAuthorId(id);
		if(CAATRepository.save(courseAuthorsAndTutor) != null)
			return true;
		return false;
	}
	//delete
	public boolean delete(int id) {
		if(CAATRepository.exists(id)) {
			CAATRepository.delete(id);
			return true;
		}
		return false;
	}
}
