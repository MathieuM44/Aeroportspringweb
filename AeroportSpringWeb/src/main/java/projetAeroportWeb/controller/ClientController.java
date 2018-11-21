package projetAeroportWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import AeroportSpring.repositories.ClientRepository;
import AeroportSpring.services.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientRepository clientRepo;

	@Autowired
	private ClientService clientService;

	@GetMapping("")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("redirect:/client/");
		return modelAndView;
	}

	@GetMapping("/")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("client/list", "clients", clientRepo.findAll());
		return modelAndView;
	}

	@GetMapping("/del")
		public ModelAndView delete(@RequestParam(name = "id")Long id){
		clientService.delete(id);
		return new ModelAndView("redirect:/client");
	}


}
