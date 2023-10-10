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

	@GetMapping("/index")
	    public String index() {
	        return "index";
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
	                             @RequestParam("gender") String gender, Model model) {
	        Student student = new Student(kodID, name, branch, email, dob, gender);
	        boolean idExists=ss.checkId(kodID);
	        boolean emailExists=ss.checkEmail(email);
	        if(idExists==false) {
	        	if(emailExists==false) {
	        		ss.addStudent(student);
	        System.out.println("Successfull Added !");
	        String result = ss.addSuccessMassage();
	        model.addAttribute("result",result);
	        return "register";
        	}else {
        		System.out.println("ID exists");
        		String result = ss.addExists();
	        	model.addAttribute("result",result);
        		return "register";
        	}
	        }else {
	        	System.out.println("email exists");
	        	String result = ss.addExists();
	        	model.addAttribute("result",result);
	        	return "register";
	        }
	        
	    }
	    

	    @GetMapping("/viewInfo")
	    public String viewInfo() {
	        return "viewInfo";
	    }
	

	    @GetMapping("/view")
	    public String getStudent(@RequestParam("kodID") String kodID, Model model) {
	    	try {
	        Student student = ss.getStudent(kodID);
	        System.out.println("successfully Get");
	        model.addAttribute("student", student);
	        return "showInfo";
	    	}catch(Exception e){
	    		return "goback";
	    	}
	    }

		@GetMapping("/showAllStudents")
	    public String showAllStudents() {
	        return "showAllStudents";
	    }

	    @GetMapping("/getAllStudents")
	    public String getAllStudents(Model model) {
	    	try {
	        List<Student> students = ss.getAllStudents();
	        model.addAttribute("students", students);
	        return "showAllStudents";
	    	}catch(Exception e) {
	    		System.out.println("Not available database");
	    		return "index";
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
		                            @RequestParam("gender") String gender, Model model) {
	        Student student = new Student(kodID, name, branch, email, dob, gender);
	        boolean idExists=ss.checkId(kodID);
	        if(idExists==true) {
	        ss.updateStudent(student);
	        String result = ss.updateSuccessMassage();
	        model.addAttribute("result1",result);
	        return "updateInfo";	
	        }else {
	        	String result = ss.updateExists();
		        model.addAttribute("result1",result);
	        	return "updateInfo";
	        }
	        
	        
	        
	    }	
	    @GetMapping("/remove")
	    public String removeStudent() {
	        return "remove";
	    }

	    @PostMapping("/deleteStudent")
	    public String deleteStudent(@RequestParam("kodID") String kodID, Model model) {
	    	boolean idExists=ss.checkId(kodID);
	    	if(idExists==true) {
	    	ss.deleteStudent(kodID);
	    	String result = ss.removeSuccessMassage();
	    	model.addAttribute("result2",result);
	        return "remove";	
	    	}else {
	    		String result = ss.removeExists();
		    	model.addAttribute("result2",result);
	    		return "remove";
	    	}
	        
	        
	    }
	    
}
