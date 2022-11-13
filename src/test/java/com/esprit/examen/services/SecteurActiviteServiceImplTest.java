package com.esprit.examen.services;

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

import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.SecteurActiviteRepository;
import com.esprit.examen.services.ISecteurActiviteService;


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

	@Test
	@Order(2)
	public void testAddSecteur() throws ParseException {
		SecteurActivite sa = new SecteurActivite(null,"test","testtest",null);
		SecteurActivite savedSecteur = secteurService.addSecteurActivite(sa);
		assertEquals(sa.getLibelleSecteurActivite(), savedSecteur.getLibelleSecteurActivite());
	}
	@Test
	//@Order(4)
	public void testDeleteStock() {
		secteurService.deleteSecteurActivite(10L);
	}

}