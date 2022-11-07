package com.esprit.examen.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;

@SpringBootTest
public class ProduitServiceImplTest {
	@Autowired
	IProduitService  produitService;
	@Autowired
	ProduitRepository produitRepository;
	@Test
	public void testcreateproduit() {
		
			Produit po = new Produit("Mootaz","farwa",new Date(),new Date());
		    Produit savedproduit= produitService.addProduit(po);	
			assertNotNull(savedproduit.getLibelleProduit());
			
			
		} 
	
@Test
public void testfindproduit() {
	Produit p= produitRepository.findById(10L).get();
	System.out.println(p);
}

@Test
public void testupdateproduit() {
	Produit p= produitRepository.findById(10L).get();
	p.setPrix(2000);
	produitRepository.save(p);
	System.out.println(p);
}


@Test
public void testFindAllproduit() {
	List<Produit> prod=produitRepository.findAll();
}
}