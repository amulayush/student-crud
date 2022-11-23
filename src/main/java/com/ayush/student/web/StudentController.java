package com.ayush.student.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayush.student.domain.Student;
import com.ayush.student.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController 
{
	@Autowired
	private StudentService studentService;

	@GetMapping("/find/{name}")
	public ResponseEntity<?> getStudentByName(@PathVariable String name)
	{
		
		Student student =  studentService.findStudentByName(name);
		
		return new ResponseEntity<Student>(student, HttpStatus.OK);
		
	}
	
	@PostMapping("")
	public ResponseEntity<?> createStudent(@Valid @RequestBody Student student)
	{
	
		Student newStudent = studentService.saveOrUpdateStudent(student);
		return new ResponseEntity<Student>(newStudent, HttpStatus.CREATED);
		
		
	}
	
	
	@GetMapping("/all")
	public Iterable<Student> getAllStudents()
	{
		return studentService.findAllStudents();
	}
	
	
	@DeleteMapping("/delete/{name}")
	public ResponseEntity<?> deleteStudent(@PathVariable String name)
	{
		studentService.deleteStudentByName(name);
		
		return new ResponseEntity<String>("Student with Name: " + name + " has been deleted", HttpStatus.OK);
	}
	
	
	
	
	
	
}
