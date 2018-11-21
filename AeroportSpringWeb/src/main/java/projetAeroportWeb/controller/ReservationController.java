package projetAeroportWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import AeroportSpring.repositories.ReservationRepository;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationRepository reservationRepository;

	@RequestMapping("")
	public ModelAndView home() {
		return new ModelAndView("redirect:/reservation/");
	}

	@GetMapping("/")
	public ModelAndView list() {
		return new ModelAndView("reservation/listreservation", "reservations", reservationRepository.findAll());
	}

//	@GetMapping("/delete")
//	public ModelAndView delete(@RequestParam(name = "id", required = true) Long id) {
//		reservationRepository.deleteById(id);
//		return new ModelAndView("redirect:/reservation/");
//	}
//
//	@GetMapping("/edit")
//	public ModelAndView edit(@RequestParam(name = "id", required = true) Long id) {
//		return goEdit(reservationRepository.findById(id).get());
//	}
//
//	@GetMapping("/add")
//	public ModelAndView add() {
//		return goEdit(new Reservation());
//	}
//
//	private ModelAndView goEdit(Reservation reservation) {
//		ModelAndView modelAndView = new ModelAndView("reservation/editreservation", "reservation", reservation);
//		return modelAndView;
//	}
//
//	@PostMapping("/save")
//	public ModelAndView save(Reservation reservation, BindingResult br) {
//		if (br.hasErrors()) {
//			return goEdit(reservation);
//		}
//		reservationRepository.save(reservation);
//		return new ModelAndView("redirect:/reservation/");
//	}
}