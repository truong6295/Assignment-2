package com.example.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cours;

@Repository
public interface CourseRepository extends JpaRepository<Cours, Integer> {
	
}
