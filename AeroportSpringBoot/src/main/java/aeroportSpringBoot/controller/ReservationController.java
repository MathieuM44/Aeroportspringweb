package aeroportSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import aeroportSpringBoot.model.Reservation;
import aeroportSpringBoot.repositories.ClientRepository;
import aeroportSpringBoot.repositories.PassagerRepository;
import aeroportSpringBoot.repositories.ReservationRepository;
import aeroportSpringBoot.repositories.VolRepository;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private VolRepository volRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private PassagerRepository passagerRepository;

	@RequestMapping("")
	public ModelAndView home() {
		return new ModelAndView("redirect:/reservation/");
	}

	@GetMapping("/")
	public ModelAndView list() {
		return new ModelAndView("reservation/listreservation", "reservations", reservationRepository.findAll());
	}

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam(name = "id", required = true) Long id) {
		reservationRepository.deleteById(id);
		return new ModelAndView("redirect:/reservation/");
	}

	@GetMapping("/edit")
	public ModelAndView edit(@RequestParam(name = "id", required = true) Long id) {
		return goEdit(reservationRepository.findById(id).get());
	}

	@GetMapping("/add")
	public ModelAndView add() {
		return goEdit(new Reservation());
	}

	private ModelAndView goEdit(Reservation reservation) {
		ModelAndView modelAndView = new ModelAndView("reservation/editreservation", "reservation", reservation);
		modelAndView.addObject("vols", volRepository.findAll());
		modelAndView.addObject("clients", clientRepository.findAll());
		modelAndView.addObject("passagers", passagerRepository.findAll());
		return modelAndView;
	}

	@PostMapping("/save")
	public ModelAndView save(Reservation reservation, BindingResult br, @RequestParam(name = "clientId") Long id) {
		if (br.hasErrors()) {
			return goEdit(reservation);
		}
		reservation.setClient(clientRepository.findById(id).get());
		reservationRepository.save(reservation);
		return new ModelAndView("redirect:/reservation/");
	}
}