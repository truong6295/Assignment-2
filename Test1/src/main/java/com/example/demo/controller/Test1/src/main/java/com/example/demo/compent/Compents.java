package com.example.demo.compent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.service.CourseService;


@Component
public class Compents implements CommandLineRunner {
	@Autowired
	private CourseService courseService;
	@Override
	public void run(String... args) throws Exception {
		
	}
	
}
