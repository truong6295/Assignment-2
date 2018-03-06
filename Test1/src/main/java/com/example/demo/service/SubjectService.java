package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SubjectRepository;
import com.example.demo.entity.Subject;
@Service
public class SubjectService {
	@Autowired
	private SubjectRepository subjectRepository;
	//add subject
	public Subject add(String eg_Database_Design,String subjectName) {
		Subject subject=new Subject(eg_Database_Design, subjectName);
		if(subjectRepository.save(subject) != null)
			return subject;
		else
			return null;
	}
	//update subject
	public Subject update(int id,String eg_Database_Design,String subjectName) {
		Subject subject=new Subject(eg_Database_Design, subjectName);
		subject.setSubjectId(id);
		if(subjectRepository.save(subject)!=null)
			return subject;
		else
			return null;
	}
	//delete
	public boolean delete(int id) {
		if(subjectRepository.exists(id)) {
			subjectRepository.delete(id);
			return true;
		}
		return false;
	}
	//view 
		public List<Subject> viewAll(){
			List<Subject> subjects= subjectRepository.findAll();
			return subjects;
		}
		//view 1 entity
		public Subject viewId(int id) {
			Subject subjects=subjectRepository.findOne(id);
			return subjects;
		}
}
