package com.example.demo.compent;

import java.util.Date;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.dao.CourseRepository;
import com.example.demo.dao.Course_Authors_and_TutorRepository;
import com.example.demo.dao.StudentRepository;
import com.example.demo.dao.Student_Course_EnrolmentRepository;
import com.example.demo.dao.Student_Tests_TakenRepository;
import com.example.demo.dao.SubjectRepository;
import com.example.demo.entity.Cours;
import com.example.demo.entity.Course_Authors_and_Tutor;
import com.example.demo.entity.Student;
import com.example.demo.entity.Student_Course_Enrolment;
import com.example.demo.entity.Subject;
import com.example.demo.service.CourseService;
import com.example.demo.service.Course_Authors_and_TutorService;
import com.example.demo.service.StudentService;
import com.example.demo.service.Student_Course_EnrolmentService;
import com.example.demo.service.Student_Tets_TakenService;
import com.example.demo.service.SubjectService;


@Component
public class Compents implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(Compents.class);
	@Autowired
	private StudentService studentService;
	@Autowired
	private Student_Course_EnrolmentService studentcourseenrolmentService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private Course_Authors_and_TutorService courseauthorsandtutorService;
	@Autowired
	private Student_Tets_TakenService studentTestTakenService;
	
	@Autowired
	private Student_Tests_TakenRepository studentTest;
	
	//------------------------add, update,delete
	
	
	//--------------------------
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		/*logger.info("BAT DAU!");
		
		long millis = System.currentTimeMillis();
        Date date1 = new Date(millis);
        Date date2=new Date(millis);
        Student st=studentService.add(date1, date2, "ba", "hay", "van", "khong", "1234", "truong");
        Subject sb=subjectService.add("hay", "lam");
        Course_Authors_and_Tutor caa= courseauthorsandtutorService.add("trong", "", "", "truong", "nguyen", "F", "asd","van", "khong", "12ddd", "asas");
        Cours cs=courseService.add("khong", "truong", "null", sb, caa);
        if(studentcourseenrolmentService.add(date1, date2, "khg", st, cs, date1, "khong", "tot"))
        	logger.info("tot!");
        if(studentTestTakenService.delete(3))
        	logger.info("xoa!");
        else
        	logger.info("false1");*/
	}
	
}
