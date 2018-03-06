package com.example.demo.controller;

import java.text.ParseException;
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

import com.example.demo.dao.Course_Authors_and_TutorRepository;
import com.example.demo.entity.Course_Authors_and_Tutor;
import com.example.demo.entity.Student;
import com.example.demo.service.Course_Authors_and_TutorService;

@RestController
@RequestMapping("/api")
public class Course_Authors_and_TutorController {
	@Autowired
	private Course_Authors_and_TutorService courseAuthorsAndTutorService;
	//view all
    @RequestMapping(value = "/courseAuthorsAndTutor/", method = RequestMethod.GET)
    public ResponseEntity<List<Course_Authors_and_Tutor>> listAllCourseAuthorsAndTutor() {
        List<Course_Authors_and_Tutor> courseAuthorsAndTutors = courseAuthorsAndTutorService.viewAll();
        if (courseAuthorsAndTutors.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Course_Authors_and_Tutor>>(courseAuthorsAndTutors, HttpStatus.OK);
    }
  //view 1 entity
    @RequestMapping(value = "/courseAuthorsAndTutor/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCourseAuthorsAndTutor(@PathVariable("id") int id) {
    	Course_Authors_and_Tutor courseAuthorsAndTutors = courseAuthorsAndTutorService.viewId(id);
        return new ResponseEntity<Course_Authors_and_Tutor>(courseAuthorsAndTutors, HttpStatus.OK);
    }
  //creat
    @RequestMapping(value = "/courseAuthorsAndTutor/",method = RequestMethod.POST)
    public ResponseEntity<?> creatCourseAuthorsAndTutor(String addressLine1,String addressLine2,String addressLine3,
			String author_tutor_ATB,String familyName,String genderMf,String loginName,
			String middleName,String otherDetails,String password,String personalName, UriComponentsBuilder ucBuilder){
        
    	Course_Authors_and_Tutor courseAuthorsAndTutors=courseAuthorsAndTutorService.add(addressLine1, addressLine2, 
    			addressLine3, author_tutor_ATB, familyName, genderMf, loginName, middleName,
    			otherDetails, password, personalName);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/courseAuthorsAndTutor/{id}").buildAndExpand(courseAuthorsAndTutors.getAuthorId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
  //update
    @RequestMapping(value = "/courseAuthorsAndTutor/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCourseAuthorsAndTutor(String authorId ,String addressLine1,String addressLine2,String addressLine3,
			String author_tutor_ATB,String familyName,String genderMf,String loginName,
			String middleName,String otherDetails,String password,String personalName) throws ParseException{
        int id=Integer.parseInt(authorId);
        Course_Authors_and_Tutor currentCourseAuthorsAndTutor = courseAuthorsAndTutorService.update(id,addressLine1,addressLine2,addressLine3,
    			author_tutor_ATB,familyName,genderMf,loginName,
    			middleName,otherDetails,password,personalName);
        return new ResponseEntity<Course_Authors_and_Tutor>(currentCourseAuthorsAndTutor, HttpStatus.OK);
    }
  //delete 1 entity
    @RequestMapping(value = "/courseAuthorsAndTutor/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCourseAuthorsAndTutor(@PathVariable("id") int authorId) {
        if(courseAuthorsAndTutorService.delete(authorId)) {
        	
        	return new ResponseEntity<Course_Authors_and_Tutor>(HttpStatus.NO_CONTENT);
        }
        else
        	return new ResponseEntity("loi xoa.student voi id {} khong co.",HttpStatus.NOT_FOUND);
    }
}
