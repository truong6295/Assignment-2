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

import com.example.demo.entity.Student_Course_Enrolment;
import com.example.demo.service.Student_Course_EnrolmentService;

@RestController
@RequestMapping("/api")
public class Student_Course_EnrolmentController {
	private static final SimpleDateFormat formatHHmm = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	Student_Course_EnrolmentService studentCourseEnrolmentService;
	//view all
    @RequestMapping(value = "/studentCourseEnrolment/", method = RequestMethod.GET)
    public ResponseEntity<List<Student_Course_Enrolment>> listAllStudentCourseEnrolment() {
        List<Student_Course_Enrolment> studentCourseEnrolments = studentCourseEnrolmentService.viewAll();
        if (studentCourseEnrolments.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Student_Course_Enrolment>>(studentCourseEnrolments, HttpStatus.OK);
    }
    //view 1 entity
    @RequestMapping(value = "/studentCourseEnrolment/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getStudentCourseEnrolment(@PathVariable("id") int id) {
    	Student_Course_Enrolment studentCourseEnrolments = studentCourseEnrolmentService.viewId(id);
        return new ResponseEntity<Student_Course_Enrolment>(studentCourseEnrolments, HttpStatus.OK);
    }
  //creat
    @RequestMapping(value = "/studentCourseEnrolment/",method = RequestMethod.POST)
    public ResponseEntity<?> creatStudentCourseEnrolment(String dateOfCompletion,String dateOfEnrolment,String otherDetails,
			String studentId,String courseId, UriComponentsBuilder ucBuilder) throws NumberFormatException, ParseException{
        
    	Student_Course_Enrolment studentCourseEnrolments=studentCourseEnrolmentService.add(formatHHmm.parse(dateOfCompletion), 
    			formatHHmm.parse(dateOfEnrolment),otherDetails,Integer.parseInt(studentId),
    			Integer.parseInt(courseId));
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/studentCourseEnrolment/{id}").buildAndExpand(studentCourseEnrolments.getRegistrationId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
  //update
    @RequestMapping(value = "/studentCourseEnrolment/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateStudentCourseEnrolment(String registrationId ,String dateOfCompletion,String dateOfEnrolment,String otherDetails,
			String studentId,String courseId) throws ParseException{
        int id=Integer.parseInt(registrationId);
        Student_Course_Enrolment currentStudentCourseEnrolment = studentCourseEnrolmentService.update(id, formatHHmm.parse(dateOfCompletion),formatHHmm.parse(dateOfEnrolment),
        		otherDetails, Integer.parseInt(studentId),Integer.parseInt(courseId));
        return new ResponseEntity<Student_Course_Enrolment>(currentStudentCourseEnrolment, HttpStatus.OK);
    }
  //delete 1 entity
    @RequestMapping(value = "/studentCourseEnrolment/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteStudentCourseEnrolment(@PathVariable("id") int registrationId) {
        if(studentCourseEnrolmentService.delete(registrationId)) {
        	
        	return new ResponseEntity<Student_Course_Enrolment>(HttpStatus.NO_CONTENT);
        }
        else
        	return new ResponseEntity("loi xoa.student voi id {} khong co.",HttpStatus.NOT_FOUND);
    }
	
}
