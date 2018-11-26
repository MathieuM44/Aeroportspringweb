package aeroportSpringBoot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import aeroportSpringBoot.model.Client;
import aeroportSpringBoot.model.Login;
import aeroportSpringBoot.repositories.LoginRepository;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("")
	public ModelAndView home() {
		return new ModelAndView("redirect:/login/");

	}

	@GetMapping(value = { "/" })
	public ModelAndView listelogin() {
		ModelAndView modelAndView = new ModelAndView("login/listelogin", "logins", loginRepository.findAll());
		return modelAndView;
	}

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam(name = "id", required = true) Long id) {
		loginRepository.deleteById(id);
		return new ModelAndView("redirect:/login/");

	}

	@GetMapping("/editlogin")
	public ModelAndView edit(@RequestParam(name = "id", required = true) Long id) {
		return goEdit(loginRepository.findById(id).get());
	}

	@GetMapping("/addLogin")
	public ModelAndView addLogin() {
		return goEdit(new Login());
	}

	private ModelAndView goEdit(Login p) {
		ModelAndView modelAndView = new ModelAndView("login/editlogin", "log", p);
		return modelAndView;
	}

	
	@GetMapping("/save")
	private ModelAndView save(@Valid @ModelAttribute("log")Login login, BindingResult br) {
		System.out.println("mark 1");
		if (br.hasErrors()) {
			for (ObjectError error :br.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			return goEdit(login);
		}
		else {
			login.setMotDePasse(passwordEncoder.encode(login.getMotDePasse()));
			loginRepository.save(login);
		}
		return new ModelAndView("redirect:/login/");
	}

	@GetMapping("/voirclient")
	public ModelAndView voirClient(@RequestParam(name = "id", required = true) Long id) {
		Login login = new Login();
		login = loginRepository.findById(id).get();
		Client c = login.getClient();
		ModelAndView modelAndView = new ModelAndView("login/clientlogin", "client", c);
		return modelAndView;
	}

}