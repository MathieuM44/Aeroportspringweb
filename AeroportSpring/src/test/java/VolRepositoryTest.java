import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import AeroportSpring.repositories.VolRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class VolRepositoryTest {

	@Autowired
	private VolRepository volRepository;
	
	@Test
	public void test() {
			assertNotNull(volRepository);
			System.out.println(volRepository.findAllReservation());
			System.out.println(volRepository.findAllAeroportDepartAndAeroportArrivee());
			System.out.println(volRepository.findAllEscale());
			System.out.println(volRepository.findAllCompagnieAerienneVol());
			System.out.println(volRepository.findAllCompagnieAerienne());		
	}

}
