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

import AeroportSpring.model.Vol;
import AeroportSpring.repositories.ReservationRepository;
import AeroportSpring.repositories.VolRepository;
import AeroportSpring.services.VolService;


@Controller
@RequestMapping("/vol")
public class VolController {

	@Autowired
	private VolRepository volrepository;

	@RequestMapping("")
	public ModelAndView home() {
		return new ModelAndView("redirect:/vol/");
	}

	@GetMapping("/")
	public ModelAndView list() {
		return new ModelAndView("vol/listvol", "vols", volrepository.findAll());
	}


	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam(name = "id", required = true) Long id) {
		volrepository.deleteById(id);
		return new ModelAndView("redirect:/vol/");
	}

//	@GetMapping("/editvol")
//	public ModelAndView edit(@RequestParam(name = "id", required = true) Long id) {
//		return goEdit(volrepository.findById(id).get());
//	}
//
//	@GetMapping("/addvol")
//	public ModelAndView addvol() {
//		return goEdit(new Formateur());
//	}
//
//	private ModelAndView goEdit(Vol vol) {
//		ModelAndView modelAndView = new ModelAndView("vol/editvol", "vol", vol);
//		return modelAndView;
//	}
//
//	@GetMapping("/saveFormateur")
//	public ModelAndView saveFormateur(@Valid @ModelAttribute("personne") Formateur personne, BindingResult br) {
//		return save(personne, br);
//	} icibon 


//
//	private ModelAndView save(Personne personne, BindingResult br) {
//		if (br.hasErrors()) {
//			return goEdit(personne);
//		}
//
//		if (personne.getSalle() != null && personne.getSalle().getNumero() == null) {
//			personne.setSalle(null);
//		}
//
//		if (personne.getId() == null) {
//			daoPersonne.create(personne);
//		} else {
//			daoPersonne.update(personne);
//		}
//		return new ModelAndView("redirect:/personne/");
//	}

}
