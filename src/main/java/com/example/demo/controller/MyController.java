package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("/")
public class MyController {

	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping("/post")
	public ResponseEntity<?> addStudent(@RequestBody Student student)
	{
		Student save = this.studentRepository.save(student);
		return ResponseEntity.ok(save);
	}
	
	@GetMapping("/get")
	public ResponseEntity<?> getStudent()
	{
		return ResponseEntity.ok(this.studentRepository.findAll());
	}
	
}
