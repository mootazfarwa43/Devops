package com.esprit.examen.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.repositories.CategorieProduitRepository;

@SpringBootTest
public class CategorieProduitImplMockTest {

	@Mock
	CategorieProduitRepository categorieRepository;
	
	@InjectMocks
	CategorieProduitServiceImpl categorieService;
	
	@Test
	public void testRetrieveCategorieProduit() {
		CategorieProduit c = new CategorieProduit((long) 1,"101","phone");
		
		Mockito.when(categorieRepository.findById(Mockito.anyLong()))
		.thenReturn(Optional.of(c));
		
		assertNotNull(categorieService.retrieveCategorieProduit(1L));
	}
	
	@Test
	public void testUpdateCategorieProduit() {
		CategorieProduit categorie = new CategorieProduit(1L,"150","Television");
	 
     CategorieProduit newCategorie = new CategorieProduit();
     newCategorie.setLibelleCategorie("tele");

     Mockito.when(categorieRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(categorie));
     
     assertNotNull(categorieService.updateCategorieProduit(newCategorie));
	}
}
