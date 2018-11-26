package aeroportSpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/connection")
public class AuthController {

	@GetMapping("")
	public ModelAndView home() {
		return new ModelAndView("redirect:/connection/");

	}

	@GetMapping(value = { "/" })
	public String login(Model model) {
		return "connection";
	}
	
//	@PostMapping("/success")
//	public ModelAndView successfullLogin() {
//		return new ModelAndView("redirect:/login/");
//	}
}
