package aeroportSpringBoot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
public class loginController {

	@Autowired
	private LoginRepository loginRepository;

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
//		Optional<Login> oplog= loginRepository.findById(id);
//		if (oplog.isPresent()) {
//			return goEdit(oplog.get());
//		} else {
//			return new ModelAndView("redirect:/login/");
//		}
		return goEdit(loginRepository.findById(id).get());
	}

	@GetMapping("addLogin")
	public ModelAndView addLogin() {
		return goEdit(new Login());
	}

	private ModelAndView goEdit(Login p) {
		ModelAndView modelAndView = new ModelAndView("login/editlogin", "login", p);
//		modelAndView.addObject("titres", Titre.values());
//		modelAndView.addObject("salles", daoSalle.findAll());
		return modelAndView;
	}

	@PostMapping("/saveLogin")
	public ModelAndView saveLogin(@Valid @ModelAttribute("login") Login login, BindingResult br) {
		return save(login, br);
	}

	private ModelAndView save(Login login, BindingResult br) {
		if (br.hasErrors()) {
			return goEdit(login);
		}

//		if(personne.getSalle()!=null&&personne.getSalle().getNumero()==null) {
//			personne.setSalle(null);
//		}
		else {
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
//		return new ModelAndView("redirect:/login/clientlogin/");

	}

}