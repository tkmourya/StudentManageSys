package com.StudManageSys.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.StudManageSys.entity.Admin;
import com.StudManageSys.services.AdminServices;



@Controller
public class AdminController {

	@Autowired
	AdminServices adminServices;
	
	@GetMapping("/index")
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
    
 // Register
 	@PostMapping("/addUsers")
     public String addUsers(  
                              @RequestParam("name") String name,
                              @RequestParam("email") String email,
                              @RequestParam("password") String password,
                              @RequestParam("re_password") String re_password,
                              @RequestParam("contact") String contact, Model model) {
         Admin admin = new Admin();
         boolean emailExists=adminServices.checkEmail(email);
         if(emailExists==false) {
        	 admin.setName(name);
        	 admin.setEmail(email);
        	 admin.setPassword(re_password);
        	 admin.setRe_password(re_password);
        	 admin.setContact(contact);
         adminServices.addUsers(admin);
        
         System.out.println(admin);
         String result = adminServices.addSuccess();
	        model.addAttribute("result",result);
         System.out.println("user added successfully!");
         return "/signup";
         }
         else {
         	String result = adminServices.addExists();
             model.addAttribute("result", result);
         	System.out.println("user already exists!");
         	return "/signup";
         }
     }
 	
 // login
 	@PostMapping("/validate")
 	public String validate(@RequestParam("email") String email,
             				@RequestParam("password") String password,Model model) {
 		if(adminServices.checkEmail(email)) {
 			
 		boolean val=adminServices.validate(email, password);
 		//if user is valid
 		if(val==true){
 			
 			System.out.println("login successfull!");
 			return "/home";
 			}
 		else {
 			String result = adminServices.loginExists();
             model.addAttribute("result", result);
 			System.out.println("incorrect credentials, try again!");
 			return "/signin";
 		}
 		
 	}else {
 		String result = adminServices.loginExists();
        model.addAttribute("result", result);
 			return "/signin";
 		}
 	}


@PostMapping("/adminValidate")
	public String adminValidate(@RequestParam("email") String email,
         				@RequestParam("password") String password,Model model) {
		if(adminServices.checkEmail(email)) {
			
		boolean val=adminServices.validate(email, password);
		//if admin is valid
		if(val==true){
			if(adminServices.getAdminEmail(email).equals("dev_tk@ubuildo.com")) {
				System.out.println("admin_login successfull!");
			return "/signup";
			}
			else {
				String result = adminServices.loginExists();
		         model.addAttribute("result", result);
					System.out.println("incorrect credentials, try again!");
					return "/adminlogin";
			}
			
			}
		else {
			String result = adminServices.loginExists();
         model.addAttribute("result", result);
			System.out.println("incorrect credentials, try again!");
			return "/adminlogin";
		}
		
	}else {
		String result = adminServices.loginExists();
    model.addAttribute("result", result);
			return "/adminlogin";
		}
	}
}


