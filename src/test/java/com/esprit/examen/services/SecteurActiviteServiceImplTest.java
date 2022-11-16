package com.esprit.examen.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.SecteurActivite;


@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
public class SecteurActiviteServiceImplTest {
	@Autowired
	ISecteurActiviteService secteurService;
	

	@Test
	@Order(1)
	public List<SecteurActivite> testRetrieveAllStocks() {
		List<SecteurActivite> allSActivite = secteurService.retrieveAllSecteurActivite();
		assertEquals(0, allSActivite.size());
		return allSActivite;
	}

	@Test
	@Order(2)
	public void testAddSecteur() {
		SecteurActivite sa = new SecteurActivite();
		sa.setCodeSecteurActivite("test");
		sa.setFournisseurs(null);
		sa.setLibelleSecteurActivite("test");
		SecteurActivite savedSecteur = secteurService.addSecteurActivite(sa);
		assertEquals(sa.getLibelleSecteurActivite(), savedSecteur.getLibelleSecteurActivite());
	}
	@Test
	@Order(3)
	public void testDeleteStock() {
		secteurService.deleteSecteurActivite(1L);
	}

}