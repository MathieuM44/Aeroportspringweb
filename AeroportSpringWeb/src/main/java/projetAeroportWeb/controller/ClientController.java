package projetAeroportWeb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import AeroportSpring.model.Client;
import AeroportSpring.model.ClientEI;
import AeroportSpring.model.ClientMoral;
import AeroportSpring.model.ClientPhysique;
import AeroportSpring.model.TitreMoral;
import AeroportSpring.model.TitrePhysique;
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
		public ModelAndView delete(@RequestParam(name = "id") Long id){
		clientService.delete(id);
		return new ModelAndView("redirect:/client");
	}


	
	
	
	@GetMapping("/edit")
	public ModelAndView edit(@RequestParam(name = "id", required = true) Long id) {
		Client client = clientService.GetWithResa(id);
		return goEdit(client);
	}

	@GetMapping("/addClientPhysique")
	public ModelAndView addClientPhysique() {
		return goEdit(new ClientPhysique());
	}

	@GetMapping("/addClientMoral")
	public ModelAndView addClientMoral() {
		return goEdit(new ClientMoral());

	}
	
	@GetMapping("/addClientEI")
	public ModelAndView addClientEI() {
		return goEdit(new ClientEI());

	}
	

	public ModelAndView goEdit(Client p) {
		ModelAndView modelAndView = new ModelAndView("client/edit", "client", p);
		modelAndView.addObject("titresP", TitrePhysique.values());
		modelAndView.addObject("titresM", TitreMoral.values());
		modelAndView.addObject("reservationss", p.getReservations());

		return modelAndView;
	}

	@GetMapping("/saveClientPhysique")
	public ModelAndView saveFormateur(@Valid @ModelAttribute("client") ClientPhysique cp, BindingResult br ) {
		return save(cp,br);

	}

	@GetMapping("/saveClientMoral")
	public ModelAndView saveFormateur(@Valid @ModelAttribute("client") ClientMoral cm, BindingResult br ) {
		return save(cm,br);

	}
	
	@GetMapping("/saveClientEI")
	public ModelAndView saveFormateur(@Valid @ModelAttribute("client") ClientEI cei, BindingResult br ) {
		return save(cei,br);

	}
	
	private ModelAndView save(Client client, BindingResult br) {
		if(br.hasErrors()) {
			return goEdit(client);
		}
		
	
			clientRepo.save(client);
	
		
		return new ModelAndView("redirect:/client/");
	}
}
