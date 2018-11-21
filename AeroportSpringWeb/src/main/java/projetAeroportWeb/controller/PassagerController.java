package projetAeroportWeb.controller;

import java.util.Optional;

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

import AeroportSpring.model.Passager;
import AeroportSpring.repositories.PassagerRepository;
import AeroportSpring.services.PassagerService;

@Controller
@RequestMapping("/passager")
public class PassagerController {

	@Autowired
	private PassagerRepository passagerRepository;
	@Autowired
	private PassagerService passagerService;

	@RequestMapping("")
	public ModelAndView home() {
		return new ModelAndView("redirect:/passager/");
	}

	@GetMapping("/")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("passager/listpassager", "passagers", passagerRepository.findAll());
		return modelAndView;
	}

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam(name = "id", required = true) Long id) {
		passagerRepository.deleteById(id);
		return new ModelAndView("redirect:/passager/");
	}

	@GetMapping("/edit")
	public ModelAndView edit(@RequestParam(name = "id", required = true) Long id) {
		Optional<Passager> opt = passagerRepository.findById(id);
		Passager passager = opt.get();
		return goEdit(passager);
	}

	@GetMapping("/addPassager")
	public ModelAndView addPassager() {
		return goEdit(new Passager());
	}

	private ModelAndView goEdit(Passager passager) {
		ModelAndView modelAndView = new ModelAndView("passager/editpassager", "passager", passager);
		return modelAndView;
	}

	@PostMapping("/savePassager")
	public ModelAndView savePassager(@Valid @ModelAttribute("passager") Passager passager, BindingResult br) {
		return save(passager, br);
	}

	public ModelAndView save(Passager passager, BindingResult br) {
		if (br.hasErrors()) {
			return goEdit(passager);
		}
		passagerRepository.save(passager);
		return new ModelAndView("redirect:/passager/");
	}
}
