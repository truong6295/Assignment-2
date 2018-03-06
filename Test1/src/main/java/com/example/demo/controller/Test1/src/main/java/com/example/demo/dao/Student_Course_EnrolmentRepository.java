package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student_Course_Enrolment;
@Repository
public interface Student_Course_EnrolmentRepository extends JpaRepository<Student_Course_Enrolment, Integer>{
	
}
