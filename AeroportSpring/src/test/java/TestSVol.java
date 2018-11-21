import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import AeroportSpring.model.Aeroport;
import AeroportSpring.model.Vol;
import AeroportSpring.repositories.AeroportRepository;
import AeroportSpring.repositories.VolRepository;
import AeroportSpring.services.AeroportService;
import AeroportSpring.services.VolService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/applicationContext.xml"})
public class TestSVol {

	@Autowired
	private VolService volService;
	
	@Autowired
	private AeroportService aeroportService;
	
	@Autowired
	private VolRepository volRepository;
	
	@Autowired
	private AeroportRepository aeroportRepository;
	
	@Test
	public void test() {
		Vol vol = new Vol();
		volService.creerVol(vol);
		Aeroport aeroportArrivee = new Aeroport();
		aeroportService.creerAeroport(aeroportArrivee);
		volService.modifierAeroportArrivee(vol, aeroportArrivee);
	}

}
