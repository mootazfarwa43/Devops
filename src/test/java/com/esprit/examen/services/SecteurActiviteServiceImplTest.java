package tn.esprit.rh.achat.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.ISecteurActiviteService;


@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
public class SecteurActiviteServiceImplTest {
	@Autowired
	ISecteurActiviteService secteurService;
	

	@Test
	@Order(1)
	public void testRetrieveAllStocks() {
		List<SecteurActivite> allSActivite = secteurService.retrieveAllSecteurActivite();
		assertEquals(0, allSActivite.size());
	}

	//@Test
	//@Order(2)
	//public void testAddSecteur() throws ParseException {
	//	SecteurActivite sa = new SecteurActivite(null,"test","testtest",null);
		//SecteurActivite savedSecteur = ISecteurActiviteService.addSecteurActivite(sa);
		//assertEquals(sa.getlibelleSecteurActivite(), savedSecteur.getlibelleSecteurActivite());
	//}
//	@Test
	////@Order(4)
	//public void testDeleteStock() {
	//	SecteurActivite.deleteSecteurActivite(10L);
	//	assertNull(SecteurActivite.deleteSecteurActivite(10L));
	//}

}