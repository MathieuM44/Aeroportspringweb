import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import AeroportSpring.repositories.CompagnieAerienneRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class CompagnieAerienneRepositoryTest {

	@Autowired
	private CompagnieAerienneRepository compagnieAerienneRepository;

	@Test
	public void test() {
		assertNotNull(compagnieAerienneRepository);
		System.out.println(compagnieAerienneRepository.findAllWithCompagnieAerienneVol());
	}
}