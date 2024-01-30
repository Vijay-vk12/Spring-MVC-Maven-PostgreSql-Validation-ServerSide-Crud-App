package com.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.dao.StudentDao;
import com.sms.model.Student;

@Service
public class StudentServiceImpl  implements StudentService{
	
	@Autowired
	private StudentDao studentDao;

	

	@Override
	public void createStudent(Student student) {
		System.out.println("service started");
		studentDao.createStudent(student);
		
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students=studentDao.getAllStudents();
		return students;
	}

	@Override
	public void deleteStudent(int sid) {
		 studentDao.deleteStudent(sid);
		
	}

	@Override
	public Student getStudent(int sid) {
		Student student=studentDao.getStudent(sid);
		return student;
	}

	 @Override
	    public boolean isStudentExistsByEmail(String email) {
	        return studentDao.isStudentExistsByEmail(email);
	    }
	 @Override
	    public boolean isStudentExistsByPhone(String phoneNumber) {
	        return studentDao.isStudentExistsByPhone(phoneNumber);
	    }

	@Override
	public void updateStudent(Student updatedStudent) {
		studentDao.updateStudent(updatedStudent);
		
	}
}
