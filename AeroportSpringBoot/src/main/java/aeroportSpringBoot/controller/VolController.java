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

import aeroportSpringBoot.model.Vol;
import aeroportSpringBoot.repositories.VolRepository;

@Controller
@RequestMapping("/vol")
public class VolController {

	@Autowired
	private VolRepository volRepository;

	public ModelAndView home() {
		return new ModelAndView("redirect:/vol/");

	}

	@GetMapping(value = { "/" })
	public ModelAndView listvol() {
		ModelAndView modelAndView = new ModelAndView("vol/listvol", "vols", volRepository.findAll());
		return modelAndView;

	}

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam(name = "id", required = true) Long id) {
		volRepository.deleteById(id);

		return new ModelAndView("redirect:/vol/");

	}

	@GetMapping("/editvol")
	public ModelAndView edit(@RequestParam(name = "id", required = true) Long id) {
		System.out.println("coucouedit");
		return goEdit(volRepository.findById(id).get());
	}

	@GetMapping("addvol")
	public ModelAndView addvol() {
		System.out.println("coucouadd");
		return goEdit(new Vol());
	}

	private ModelAndView goEdit(Vol vol) {
		ModelAndView modelAndView = new ModelAndView("vol/editvol", "vol", vol);
		return modelAndView;
	}

	@PostMapping("/savevol")
	public ModelAndView savevol(@Valid @ModelAttribute("vol") Vol vol, BindingResult br) {
		return save(vol, br);
	}

	private ModelAndView save(Vol vol, BindingResult br) {
		if (br.hasErrors()) {
			return goEdit(vol);
		}

		else {
			volRepository.save(vol);

		}
		return new ModelAndView("redirect:/vol/");
	}
}