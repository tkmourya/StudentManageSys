package com.StudManageSys.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {

	
	@GetMapping("")
    public String index() {
        return "index";
    }
	
	@GetMapping("/about")
    public String about() {
        return "about";
    }
	
	@GetMapping("/alertsignup")
    public String alertsignup() {
        return "alertsignup";
    }
	
	@GetMapping("/adminlogin")
    public String adminlogin() {
        return "adminlogin";
    }
	
	@GetMapping("/signin")
	public String signin() {
    return "signin";
	}
    
    @GetMapping("/signup")
	public String signup() {
    return "signup";
}
    
    @GetMapping("/home")
    public String home() {
        return "home";
    }

 @GetMapping("/register")
    public String register() {
        return "register";
    }
 
 @GetMapping("/viewInfo")
 public String viewInfo() {
     return "viewInfo";
 }
 
 @GetMapping("/showAllStudents")
 public String showAllStudents() {
     return "showAllStudents";
 }
 
 @GetMapping("/updateInfo")
 public String updateInfo() {
     return "updateInfo";
 }
 
 @GetMapping("/remove")
 public String removeStudent() {
     return "remove";
 }
}
