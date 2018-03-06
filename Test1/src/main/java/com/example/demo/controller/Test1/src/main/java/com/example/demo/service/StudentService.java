package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentRepository;
import com.example.demo.entity.Student;
@Service
public class StudentService {
	@Autowired
	private StudentRepository studentrepository;
	//add student
	public Student add(Date dateOfLatestLogon,Date dateOfRegistration,String familyName,String loginName,String middleName,String otherDetails,String password,String personalName) {
		Student students=new Student(dateOfLatestLogon,dateOfRegistration,familyName,loginName,middleName,otherDetails,password,personalName);
		if(studentrepository.save(students) != null)
			return students;
		else
			return null;
	}
	//update student
	public Student update(int id,Date dateOfLatestLogon,Date dateOfRegistration,String familyName,String loginName,String middleName,String otherDetails,String password,String personalName) {
		Student student=new Student(dateOfLatestLogon,dateOfRegistration,familyName,loginName,middleName,otherDetails,password,personalName);
		student.setStudentId(id);
		if(studentrepository.save(student)!=null)
			return student;
		else
			return null;
	}
	//delete
	public boolean delete(int id) {
		if(studentrepository.exists(id)) {
			studentrepository.delete(id);
			return true;	
		}
		return false;
	}
	//view 
	public List<Student> viewAll(){
		List<Student> students= studentrepository.findAll();
		return students;
	}
	//view 1 entity
	public Student viewId(int id) {
		Student students=studentrepository.findOne(id);
		return students;
	}
}
