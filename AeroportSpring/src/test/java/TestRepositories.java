import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import AeroportSpring.model.Passager;
import AeroportSpring.repositories.AeroportRepository;
import AeroportSpring.repositories.ClientRepository;
import AeroportSpring.repositories.CompagnieAerienneRepository;
import AeroportSpring.repositories.CompagnieAerienneVolRepository;
import AeroportSpring.repositories.EscaleRepository;
import AeroportSpring.repositories.LoginRepository;
import AeroportSpring.repositories.PassagerRepository;
import AeroportSpring.repositories.ReservationRepository;
import AeroportSpring.repositories.VilleAeroportRepository;
import AeroportSpring.repositories.VilleRepository;
import AeroportSpring.repositories.VolRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestRepositories {

@Autowired	
AeroportRepository aeroportRepository;
@Autowired
ClientRepository clientRepository;
@Autowired
CompagnieAerienneRepository compagnieAerienneRepository;
@Autowired
CompagnieAerienneVolRepository compagnieAerienneVolRepository;
EscaleRepository escaleRepository;
@Autowired
LoginRepository loginRepository;
@Autowired
PassagerRepository passagerRepository;
@Autowired
ReservationRepository reservationRepository;
@Autowired
VilleAeroportRepository villeAeroportRepository;
@Autowired
VilleRepository villeRepository;
@Autowired
VolRepository volRepository;

@Test
public void init() {
	assertTrue(true);
	Passager passager = new Passager("Henry", "Machin");
	passagerRepository.save(passager);
}

}
