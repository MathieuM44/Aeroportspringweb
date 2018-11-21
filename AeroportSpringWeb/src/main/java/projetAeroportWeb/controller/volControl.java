package projetAeroportWeb.controller;

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

import AeroportSpring.model.Login;
import AeroportSpring.model.Vol;
import AeroportSpring.repositories.LoginRepository;
import AeroportSpring.repositories.VolRepository;

@Controller
@RequestMapping("/vol")
public class volControl {

	@Autowired
	private VolRepository volRepository;

	public ModelAndView home() {
		return new ModelAndView("redirect:/vol/");

	}

	@GetMapping(value = { "/" })
	public ModelAndView listelogin() {
		ModelAndView modelAndView = new ModelAndView("vol/listevol", "vols", volRepository.findAll());
		return modelAndView;

	}

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam(name = "id", required = true) Long id) {

		volRepository.deleteById(id);
		return new ModelAndView("redirect:/vol/");

	}

	@GetMapping("/editlogin")
	public ModelAndView edit(@RequestParam(name = "id", required = true) Long id) {
//		Optional<Login> oplog= loginRepository.findById(id);
//		if (oplog.isPresent()) {
//			return goEdit(oplog.get());
//		} else {
//			return new ModelAndView("redirect:/login/");
//		}
		return goEdit(volRepository.findById(id).get());
	}

	@GetMapping("addVol")
	public ModelAndView addVol() {
		return goEdit(new Vol());
	}

	private ModelAndView goEdit(Vol p) {
		ModelAndView modelAndView = new ModelAndView("vol/editvol", "vol", p);
//		modelAndView.addObject("titres", Titre.values());
//		modelAndView.addObject("salles", daoSalle.findAll());
		return modelAndView;
	}

	@PostMapping("/saveVol")
	public ModelAndView saveLogin(@Valid @ModelAttribute("vol") Vol vol, BindingResult br) {
		return save(vol, br);
	}

	private ModelAndView save(Vol vol, BindingResult br) {
		if (br.hasErrors()) {
			return goEdit(vol);
		}

//		if(personne.getSalle()!=null&&personne.getSalle().getNumero()==null) {
//			personne.setSalle(null);
//		}
		else {
			loginRepository.save(login);
		}
		return new ModelAndView("redirect:/login/");
	}
}