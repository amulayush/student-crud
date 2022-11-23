package com.ayush.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayush.student.domain.Student;
import com.ayush.student.repository.StudentRepository;

@Service
public class StudentService 
{
	
	@Autowired
	StudentRepository studentRepository;

	public Student saveOrUpdateStudent(Student student)
	{
			return studentRepository.save(student);
	}
	
	public Student findStudentByName(String name) 
	{
		Student student = studentRepository.findByName(name);
		return student;
	}
	
	public Iterable<Student> findAllStudents()
	{
		return studentRepository.findAll();
	}
	
	public void deleteStudentByName(String name)
	{
		Student student = studentRepository.findByName(name);
		
		studentRepository.delete(student);
		
	}

	
}
