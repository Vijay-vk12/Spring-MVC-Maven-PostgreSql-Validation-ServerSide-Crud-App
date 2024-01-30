package com.sms.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.sms.model.Student;

@Component
public class StudentDAOImpl implements StudentDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	

	@Transactional
	public void createStudent(Student student) {
		System.out.println("dao started");

		this.hibernateTemplate.save(student);

	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}

	@Transactional
	public void deleteStudent(int sid) {
		Student student = this.hibernateTemplate.load(Student.class, sid);
		this.hibernateTemplate.delete(student);
	}

	public Student getStudent(int sid) {
		
		return this.hibernateTemplate.get(Student.class, sid);
	}



	 @Override
	    public boolean isStudentExistsByEmail(String email) {
	        List<?> result = hibernateTemplate.findByNamedQueryAndNamedParam(
	                "Student.findByEmail",
	                new String[]{"email"},
	                new Object[]{email}
	        );

	        return !result.isEmpty();
	    }

	 @Override
	    public boolean isStudentExistsByPhone(String phoneNumber) {
	        List<?> result = hibernateTemplate.findByNamedQueryAndNamedParam(
	                "Student.findByPhoneNumber",
	                new String[]{"phoneNumber"},
	                new Object[]{phoneNumber}
	        );

	        return !result.isEmpty();
	    }

	@Override
	@Transactional
	public void updateStudent(Student updatedStudent) {
		hibernateTemplate.update(updatedStudent);
		
	}
}
