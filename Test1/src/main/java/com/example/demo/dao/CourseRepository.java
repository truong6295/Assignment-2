package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Cours;
import com.example.demo.entity.Student;

public interface CourseRepository extends JpaRepository<Cours, Integer> {
	
}
