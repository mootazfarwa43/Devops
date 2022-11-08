package com.esprit.examen.services;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.esprit.examen.entities.Produit;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProduitServiceImplTest {

	 @Autowired
	    
	    IProduitService ps;

    @Test
    void retrieveAllProduits() {
    	List<Produit> listProduits = ps.retrieveAllProduits();
        Assertions.assertEquals(0, listProduits.size());
    }
    
	private String codeProduit;
	private String libelleProduit;
	private float prix;

	private Date dateCreation;
	
	private Date dateDerniereModification;
    @Test
    public void testAddProduit(){
    List<Produit> Produits = ps.retrieveAllProduits();
    int expected = Produits.size();
    Produit p = new Produit();
    p.setLibelleProduit("test");
    p.setCodeProduit("codeProduit");
    p.setPrix(10);
    Date m = new Date(2022,11,05);
    p.setDateCreation(m);

    Produit savedProduit= ps.addProduit(p);
    assertEquals(expected+1, ps.retrieveAllProduits().size());
    assertNotNull(savedProduit.getLibelleProduit());
    ps.deleteProduit(savedProduit.getIdProduit());

    }



    @Test
    public void testUpdateProduit() {
    Produit p = new Produit();
    p.setLibelleProduit("test");
    p.setLibelleProduit("test");
    p.setCodeProduit("codeProduit");
    p.setPrix(10);
    Date m = new Date(2022,11,05);
    p.setDateCreation(m);
    Produit savedProduit= ps.addProduit(p);
    savedProduit.setLibelleProduit("testproduit");;
    ps.updateProduit(savedProduit);
    assertEquals(p.getLibelleProduit(),savedProduit.getLibelleProduit());
    ps.deleteProduit(savedProduit.getIdProduit());
    }

    @Test
    public void testDeleteProduit() {
    Produit p = new Produit();
    p.setLibelleProduit("test");
    p.setLibelleProduit("test");
    p.setCodeProduit("codeProduit");
    p.setPrix(10);
    Date m = new Date(2022,11,05);
    p.setDateCreation(m);
    Produit savedService= ps.addProduit(p);
    ps.deleteProduit(savedService.getIdProduit());
    assertNotNull(savedService.getIdProduit());

    }

}