package com.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import org.hibernate.validator.constraints.Email;


@Entity
@NamedQueries({
		@NamedQuery(
		        name = "Student.findByEmail",
		        query = "FROM Student s WHERE s.email = :email"
		),
		@NamedQuery(
		        name = "Student.findByPhoneNumber",
		        query = "FROM Student s WHERE s.phoneNumber = :phoneNumber"
		)
		
		
}	)
public class Student {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Size(min=4,max=20, message="Name must be more than 4")
	private String name;
	@NotNull(message="age must be not null")
	 @Pattern(regexp = "^(1[6-9]|[2][0-9])$", message = "Age must be a number greater than 15 and less than 30")
	private String age;
	@Column(unique = true)
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile must starts with 6-9 and exact 10 digits")
	private String phoneNumber;
	//@Size(min=8,max=50,message="address more than 8 char")
	private String address;
	@Column(unique = true)
	@Email(message="enter valid email")
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + ", address="
				+ address + ", email=" + email + "]";
	}
	public Student(int id, String name, String age, String phoneNumber, String address, String email) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
