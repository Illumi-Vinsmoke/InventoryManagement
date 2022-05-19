/**
 *@Descritpion: Login controller to perform tasks related to Admin Users.(login, save,delete, update, find and find all)
 *@ClassName:LoginController
 *@author shubhams11
 *@Date 19-04-2022
 */
package com.inventoryManagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.inventoryManagement.exceptions.RecordNotFoundException;
import com.inventoryManagement.model.UserModel;
import com.inventoryManagement.model.UserRoleMapping;
import com.inventoryManagement.serviceInterface.LoginServiceInterface;

@Controller
public class LoginController {

	@Autowired
	private LoginServiceInterface loginService;

	// Home Page mapping
	@RequestMapping(value = {"/index","/"}, method = RequestMethod.GET)
	public ModelAndView loginPage(ModelAndView model) {
		model.setViewName("login");
		return model;
	}

	// Register controller for registration from.
	@GetMapping("/register")
	public String register() {
		return "registrationform";
	}

	// Saving new member admin, super admin or user.
	@PostMapping("/save")
	public String newUser(@ModelAttribute UserModel user, Model model) {
		UserModel userSaved = loginService.saveUser(user);
		return findAllUser(user.getRoleId(), model);
	}
	// taking data to Update user details.
		@RequestMapping("/updateform/{id}")
		public String updateForm(@PathVariable (value ="id") Integer id, Model model) throws RecordNotFoundException { 
		UserModel user=loginService.findUser(id);
		 model.addAttribute("User",user);
		 return "Updateform";
		}

	// Updating existing user.
	@PostMapping("/update")
	public String updateUser(@ModelAttribute UserModel user, Model model) throws RecordNotFoundException {
		loginService.updateUser(user);
		String page=findAllUser(user.getRoleId(),model);
		return page;
	}

	// Login credentials check.
	@PostMapping("/login")
	public String login(@RequestParam String userName, @RequestParam String password, Model model) {

		UserModel user = loginService.login(userName, password);
		Integer roleId = user.getRoleId();

		// if user is present it will check his role and produce desired page.
		if (user != null) {
			model.addAttribute("name", user.getName());
			switch (roleId) {
			case 1:
				return "loginSuperAdmin";
			case 2:
				return "loginAdmin";
			case 3:
				return "loginuser";
			default:
				return "invalidCredentials";
			}
		} else
			return "invalidCredentials";
	}

	// to delete a user from database
	@GetMapping("/deleteUser/{id}/{role}")
	public String deleteUser(@PathVariable(value = "id") Integer id,@PathVariable(value = "role") Integer role, Model model) {
		loginService.deleteUser(id);
		String page=findAllUser(role,model);	
		return page;
	}


	
	//Method 1 to find all user record from database based on given.
	// find all method gives all record using stream API filtration of record to select only record that matches the role.
		@GetMapping(value = "/findAllUser/{role}")
		public String findAllUser(@PathVariable(value = "role") Integer role, Model model) {
			List<UserModel> userRecord = new ArrayList<UserModel>();
			List<UserRoleMapping> users = loginService.findRoleUsers();
			List<UserRoleMapping> filterUsers = users.stream()
					.filter(a -> a.getRole().getRoleId() == role)
					.collect(Collectors.toList());
			for(UserRoleMapping user: filterUsers) {
				UserModel u = new UserModel();
				u = user.getUser();
				userRecord.add(u);
			}
			
			model.addAttribute("userRecord", userRecord);
			return "findalluser";
		}
		
}
