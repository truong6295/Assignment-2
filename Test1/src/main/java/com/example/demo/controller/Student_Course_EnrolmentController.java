package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.dao.Student_Course_EnrolmentRepository;
import com.example.demo.entity.Student;
import com.example.demo.entity.Student_Course_Enrolment;

@RestController
@RequestMapping("/api")
public class Student_Course_EnrolmentController {
	public static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	Student_Course_EnrolmentRepository studentCourseEnrolmentRepository;
	
	/*@RequestMapping(value="/studentCourseEnrolment/", method= RequestMethod.GET )
	public ResponseEntity<List<Student_Course_Enrolment>> listAllStudent() {
        List<Student_Course_Enrolment> studentCourseEnrolments = studentCourseEnrolmentRepository.findAll();
        if (studentCourseEnrolments.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Student_Course_Enrolment>>(studentCourseEnrolments, HttpStatus.OK);
    }*/
	//creat
    /*@RequestMapping(value = "/student/", method = RequestMethod.POST)
    public ResponseEntity<?> studentUser(@RequestBody Student students, UriComponentsBuilder ucBuilder) {
        logger.info("tao student : {}", students);
        
        studentRepository.save(students);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/student/{id}").buildAndExpand(students.getStudentId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }*/
	
	
}
