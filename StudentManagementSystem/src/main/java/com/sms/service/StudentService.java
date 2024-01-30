package com.sms.service;

import java.util.List;

import com.sms.model.Student;

public interface StudentService {

	void createStudent(Student student);

	List<Student> getAllStudents();

	void deleteStudent(int sid);

	Student getStudent(int sid);

	void updateStudent(Student updatedStudent);

	boolean isStudentExistsByEmail(String email);

	boolean isStudentExistsByPhone(String email);

}
