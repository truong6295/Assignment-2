package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student_Tests_Taken;
@Repository
public interface Student_Tests_TakenRepository extends JpaRepository<Student_Tests_Taken, Integer>{
	Student_Tests_Taken findByPrimaryKeyStudentCourseEnrolmentRegistrationId(int registrationId);
}
