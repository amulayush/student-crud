package com.ayush.student.repository;

import com.ayush.student.domain.Student;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>
{
	Student findByName(String name);

	@Override
	Iterable<Student> findAll();
}






