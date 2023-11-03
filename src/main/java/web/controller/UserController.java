package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;


@Controller
//@RequestMapping("/users")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public String showAllUsers(Model model) {

		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}

	@GetMapping("/new-user")
	public String addNewUser(Model model) {
		model.addAttribute("user", new User());
		return "new-user";
	}

	@PostMapping()
	public String saveUser(@ModelAttribute("user") User user,
							 BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "new-user";
		}
		userService.createUser(user);
		return "redirect:/users";
	}



	
}