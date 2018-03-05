package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;



@RestController
@RequestMapping("/api")
public class StudentController {
	 	private static final SimpleDateFormat formatHHmm = new SimpleDateFormat("yyyy-MM-dd");
	    @Autowired
	    StudentService studentService;
	    //view all
	    @RequestMapping(value = "/student/", method = RequestMethod.GET)
	    public ResponseEntity<List<Student>> listAllStudent() {
	        List<Student> students = studentService.viewAll();
	        if (students.isEmpty()) {
	            return new ResponseEntity(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	    }
	    //view 1 entity
	    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	    public ResponseEntity<?> getUser(@PathVariable("id") int id) {
	        Student students = studentService.viewId(id);
	        return new ResponseEntity<Student>(students, HttpStatus.OK);
	    }
	    //creat
	    @RequestMapping(value = "/student/",method = RequestMethod.POST)
	    public ResponseEntity<?> studentUser(String dateOfLatestLogon,String dateOfRegistration,String familyName,String loginName,String middleName,String otherDetails,String password,String personalName, UriComponentsBuilder ucBuilder) throws ParseException {
	        
	        Student students=studentService.add(formatHHmm.parse(dateOfLatestLogon), formatHHmm.parse(dateOfRegistration), 
	        		familyName, loginName, middleName, otherDetails, password, personalName);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/api/student/{id}").buildAndExpand(students.getStudentId()).toUri());
	        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	    }
	    //update
	    
	    @RequestMapping(value = "/student/", method = RequestMethod.PUT)
	    public ResponseEntity<?> updateUser(String studentId ,String dateOfLatestLogon,String dateOfRegistration,String familyName,String loginName,String middleName,String otherDetails,String password,String personalName) throws ParseException{
	        int id=Integer.parseInt(studentId);
	        Student currentStudent = studentService.update(id, formatHHmm.parse(dateOfLatestLogon),formatHHmm.parse(dateOfRegistration), 
	        		familyName, loginName, middleName, otherDetails, password, personalName);
	        return new ResponseEntity<Student>(currentStudent, HttpStatus.OK);
	    }
	    //delete 1 entity
	    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
	        if(studentService.delete(id)) {
	        	
	        	return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	        }
	        else
	        	return new ResponseEntity("loi xoa.student voi id {} khong co.",HttpStatus.NOT_FOUND);
	    }
	 
}
