package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.example.demo.entity.Student_Tests_Taken;
import com.example.demo.service.Student_Tets_TakenService;

@RestController
@RequestMapping("/api")
public class Student_Test_TakenController {
	private static final SimpleDateFormat formatHHmm = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    private Student_Tets_TakenService studentTetsTakenService;
    
  //view all
    @RequestMapping(value = "/studentTetsTaken/", method = RequestMethod.GET)
    public ResponseEntity<List<Student_Tests_Taken>> listAllStudentTetsTaken() {
        List<Student_Tests_Taken> studentTetsTakens = studentTetsTakenService.viewAll();
        if (studentTetsTakens.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Student_Tests_Taken>>(studentTetsTakens, HttpStatus.OK);
    }
    //view 1 entity
    @RequestMapping(value = "/studentTetsTaken/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getStudentTetsTaken(@PathVariable("id") int id) {
    	Student_Tests_Taken studentTetsTakens = studentTetsTakenService.viewId(id);
        return new ResponseEntity<Student_Tests_Taken>(studentTetsTakens, HttpStatus.OK);
    }
  //creat
    @RequestMapping(value = "/studentTetsTaken/",method = RequestMethod.POST)
    public ResponseEntity<?> creatStudentTetsTaken(String registrationId,String dateTestTaken,String otherDetails,String testResult, UriComponentsBuilder ucBuilder) throws NumberFormatException, ParseException{
        
    	Student_Tests_Taken studentTetsTakens=studentTetsTakenService.add(formatHHmm.parse(dateTestTaken), otherDetails, testResult,Integer.parseInt(registrationId));
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/studentTetsTaken/{id}").buildAndExpand(studentTetsTakens.getStudentCourseEnrolment().getRegistrationId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
}
