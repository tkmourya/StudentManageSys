package com.StudManageSys.api;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.StudManageSys.entity.Student;
import com.StudManageSys.services.StudentServices;

@Controller
public class StudentController {
	StudentServices ss;

	public StudentController(StudentServices ss) {
		super();
		this.ss = ss;
	}

	 @GetMapping("/register")
	    public String register() {
	        return "register";
	    }

	    @PostMapping("/addStudent")
	    public String addStudent(@RequestParam("kodID") String kodID,
	                             @RequestParam("name") String name,
	                             @RequestParam("branch") String branch,
	                             @RequestParam("email") String email,
	                             @RequestParam("dob") String dob,
	                             @RequestParam("gender") String gender) {
	        Student student = new Student(kodID, name, branch, email, dob, gender);
	        ss.addStudent(student);
	        return "register";
	    }

	    @GetMapping("/viewInfo")
	    public String viewInfo() {
	        return "viewInfo";
	    }
	

	    @GetMapping("/view")
	    public String getStudent(@RequestParam("kodID") String kodID, Model model) {
	        Student student = ss.getStudent(kodID);
	        model.addAttribute("student", student);
	        return "showInfo";
	    }

	    @GetMapping("/getAllStudents")
	    public String getAllStudents(Model model) {
	    	try {
	        List<Student> students = ss.getAllStudents();
	        model.addAttribute("students", students);
	        return "showAllStudents";
	    	}catch(Exception e) {
	    		return "Empaty";
	    	}
	    }
	
	    @GetMapping("/updateInfo")
	    public String updateInfo() {
	        return "updateInfo";
	    }

	    @PostMapping("/updateStudent")
	    public String updateStudent(@RequestParam("kodID") String kodID,
	                                @RequestParam("name") String name,
	                                @RequestParam("branch") String branch,
	                                @RequestParam("email") String email,
		                            @RequestParam("dob") String dob,
		                            @RequestParam("gender") String gender) {
	        Student student = new Student(kodID, name, branch, email, dob, gender);
	        ss.updateStudent(student);
	        return "updateInfo";
	    }	
	    @GetMapping("/remove")
	    public String removeStudent() {
	        return "remove";
	    }

	    @PostMapping("/deleteStudent")
	    public String deleteStudent(@RequestParam("kodID") String kodID) {
	        ss.deleteStudent(kodID);
	        return "remove";
	        
	    }
}
