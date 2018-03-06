package com.example.demo.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.entity.Cours;
import com.example.demo.service.CourseService;

@RestController
@RequestMapping("/api")
@Transactional
public class CourseController {
	@Autowired
    private CourseService courseService;
    //view all
    @RequestMapping(value = "/course/", method = RequestMethod.GET)
    public ResponseEntity<List<Cours>> listAllCourse() {
        List<Cours> courses = courseService.viewAll();
        if (courses.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Cours>>(courses, HttpStatus.OK);
    }
    //view 1 entity
    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCourse(@PathVariable("id") int id) {
        Cours courses = courseService.viewId(id);
        return new ResponseEntity<Cours>(courses, HttpStatus.OK);
    }
  //creat
    @RequestMapping(value = "/course/",method = RequestMethod.POST)
    public ResponseEntity<?> courseSubjectcourseAuthorsAndTutor(String courseDescription,String courseName,
    		String otherDetails,String subjectId,String courseAuthorsAndTutorId, UriComponentsBuilder ucBuilder){
        Cours courses=courseService.add(courseDescription, courseName, otherDetails,
        		Integer.parseInt(subjectId), Integer.parseInt(courseAuthorsAndTutorId));
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/course/{id}").buildAndExpand(courses.getCourseId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    //update
    @RequestMapping(value = "/course/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCourse(String courseId ,String courseDescription,String courseName,
    		String otherDetails,String subjectId,String courseAuthorsAndTutorId){
        Cours currentCourse = courseService.update(Integer.parseInt(courseId), courseDescription, 
        		courseName, otherDetails, Integer.parseInt(subjectId), Integer.parseInt(courseAuthorsAndTutorId));
        return new ResponseEntity<Cours>(currentCourse, HttpStatus.OK);
    }
    //delete
    @RequestMapping(value = "/course/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCourse(@PathVariable("id") Integer courseId) {
        if(courseService.delete(courseId)) {
        	return new ResponseEntity<Cours>(HttpStatus.NO_CONTENT);
        }
        else
        	return new ResponseEntity("loi xoa.course voi id {} khong co.",HttpStatus.NOT_FOUND);
    }
}
