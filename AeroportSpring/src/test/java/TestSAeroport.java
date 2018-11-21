import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import AeroportSpring.repositories.AeroportRepository;
import AeroportSpring.repositories.VolRepository;
import AeroportSpring.services.AeroportService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/applicationContext.xml"})
public class TestSAeroport {

	@Autowired
	private AeroportService aeroportService;
	
	@Autowired
	private AeroportRepository aeroportRepository;
	
	@Autowired
	private VolRepository volRepository;
	
	@Test
	public void test() {
//		aeroportService.modifierNomAeroport((long) 1, "RCG");
//		aeroportService.creerAeroport("Orly");
//		aeroportService.supprimerAeroport("RCG");
	}

}
