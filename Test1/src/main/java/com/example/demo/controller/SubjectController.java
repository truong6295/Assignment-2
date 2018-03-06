package com.example.demo.controller;
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

import com.example.demo.entity.Subject;
import com.example.demo.service.SubjectService;

@RestController
@RequestMapping("/api")
public class SubjectController {
	@Autowired
	private SubjectService subjectService;
	//view all
    @RequestMapping(value = "/subject/", method = RequestMethod.GET)
    public ResponseEntity<List<Subject>> listAllSubject() {
        List<Subject> subjects = subjectService.viewAll();
        if (subjects.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Subject>>(subjects, HttpStatus.OK);
    }
  //view 1 entity
    @RequestMapping(value = "/subject/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getSubject(@PathVariable("id") int id) {
        Subject subjects = subjectService.viewId(id);
        return new ResponseEntity<Subject>(subjects, HttpStatus.OK);
    }
  //creat
    @RequestMapping(value = "/subject/",method = RequestMethod.POST)
    public ResponseEntity<?> creatSubject(String eg_Database_Design,String subjectName, UriComponentsBuilder ucBuilder){
        
        Subject subjects=subjectService.add(eg_Database_Design,subjectName);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/subject/{id}").buildAndExpand(subjects.getSubjectId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
  //update
    @RequestMapping(value = "/subject/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateSubject(String subjectId,String eg_Database_Design,String subjectName){
        int id=Integer.parseInt(subjectId);
        Subject currentSubject = subjectService.update(id,eg_Database_Design,subjectName);
        return new ResponseEntity<Subject>(currentSubject, HttpStatus.OK);
    }
  //delete 1 entity
    @RequestMapping(value = "/subject/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSubjecct(@PathVariable("id") int subjectId) {
        if(subjectService.delete(subjectId)) {
        	
        	return new ResponseEntity<Subject>(HttpStatus.NO_CONTENT);
        }
        else
        	return new ResponseEntity("loi xoa.student voi id {} khong co.",HttpStatus.NOT_FOUND);
    }
}
