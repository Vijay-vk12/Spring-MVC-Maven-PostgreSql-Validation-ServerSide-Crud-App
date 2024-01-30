package com.sms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.view.RedirectView;

import com.sms.model.Student;
import com.sms.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;
	
   //index list of students
	@GetMapping("/")
	public String welcome(Model m) {
		List<Student> students = service.getAllStudents();
		m.addAttribute("students", students);
		return "index";
	}

	// show studentform
	@GetMapping("/add-student")
	public String addStudent(Model m) {
	
		m.addAttribute("student", new Student());
		System.out.println("form called");
		return "add_student_form";
	}

	// handle form

	// @RequestMapping(value="/handle-student",method=RequestMethod.POST)
	@PostMapping("/handle-student")
	public String handleStudent(@ModelAttribute("student") @Valid Student student, BindingResult result,Model model) {
		validateStudent(student, result);
		System.out.println("before error");
		if (result.hasErrors()) {
			FieldError errors=result.getFieldError();
			model.addAttribute("fieldErrors", result.getFieldErrors());
			//model.addAttribute("result", result);
			System.out.println("error occured");
			List<FieldError>error=result.getFieldErrors();
			for(FieldError e:error) {
				System.out.println(e);
			}	
			return "add_student_form";
		} else {
			System.out.println(student);

	        if (service.isStudentExistsByEmail(student.getEmail())) {
	            model.addAttribute("emailMessage", "Email already exists");
	            return "add_student_form";
	        }
	        else  if (service.isStudentExistsByPhone(student.getPhoneNumber())) {
	            model.addAttribute("phoneMessage", "PhoneNumber already exists");
	            return "add_student_form";
	        }
	        else
	        {
	        	System.out.println("-----");
	        	System.out.println("student registerd succesfully");
             service.createStudent(student);
             return "redirect:/";	
	        }

			
		}

	}

	private void validateStudent(Student student, BindingResult result) {
		validateName(student.getName(), result);
		validateEmail(student.getEmail(), result);
		validatePhoneNumber(student.getPhoneNumber(), result);
		validateAge(student.getAge(), result);	
	//	validateAddress(student.getAddress(), result);
	}

	private void validateName(String name, BindingResult result) {
	    if (name == null || name.length() < 4) {
	        result.rejectValue("name", "error.name", "Name must be more than 4 characters");
	    }
	}


	private void validateAge(String age, BindingResult result) {
		try {
			int ageValue = Integer.parseInt(age);
			if (ageValue < 14 || ageValue >=30) {
				result.rejectValue("age", "age.invalid", "Age must be between 15 and 29");
			}
		} catch (NumberFormatException e) {
			result.rejectValue("age", "age.invalid", "Age must be a valid number");
		}
	}

	private void validatePhoneNumber(String phoneNumber, BindingResult result) {
		if (!phoneNumber.matches("^[6-9]\\d{9}$")) {
			result.rejectValue("phoneNumber", "phoneNumber.invalid", "Invalid phone number ");
		}
	}

	private void validateEmail(String email, BindingResult result) {
	    if (email == null || !email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$")) {
	        result.rejectValue("email", "error.email", "Enter a valid email address");
	    }
	}
	
//	private void validateAddress(String address, BindingResult result) {
//		if (address == null || (address.length() <=6)||address.length()>=50) {
//			result.rejectValue(address, "error.address", "enter valid address more than 6 chars");
//		}
//	}

	// delete
	@GetMapping("/delete/{studentId}")
	public String deleteStudent(@PathVariable("studentId") int studentId, HttpServletRequest req) {
		this.service.deleteStudent(studentId);
		return "redirect:/";

	}
	

	// update
	@GetMapping("/update/{studentId}")
	public String updateForm(@PathVariable("studentId") int id, Model model) {
		Student student = this.service.getStudent(id);
		model.addAttribute("student", student);
		return "update-form";
	}
	// update
	 @PostMapping("/update")
	    public String handleUpdateForm(@ModelAttribute("student") Student updatedStudent){
	        service.updateStudent(updatedStudent);
	        return "redirect:/";
    }
}
