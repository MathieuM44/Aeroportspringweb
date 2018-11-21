import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import AeroportSpring.model.Aeroport;
import AeroportSpring.model.Ville;
import AeroportSpring.model.VilleAeroport;
import AeroportSpring.model.VilleAeroportKey;
import AeroportSpring.repositories.AeroportRepository;
import AeroportSpring.repositories.VilleRepository;
import AeroportSpring.services.VilleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/applicationContext.xml"})
public class TestSVille {

	@Autowired
	private VilleService villeService;
	
	@Autowired
	private VilleRepository villeRepository;
	
	@Autowired
	private AeroportRepository aeroportRepository;
	
	@Test
	public void test() {
		//villeService.modifierNomVille((long) 2, "Londres");
		//villeService.creerVille("Milan");
		//villeService.supprimerVille("Paris");
	}

}
