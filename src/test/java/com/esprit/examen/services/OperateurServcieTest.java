package tn.esprit.rh.achat;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.IProduitService;
import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.IOperateurService;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class OperateurServcieTest {
	
	@MockBean
	private OperateurRepository operateurRepository;
	
	private Operateur operateur1 = new Operateur("cyrine","ben hassine","546125");
	private Operateur operateur2 = new Operateur("dina","ben hassine","546125");
	  
	@Autowired
	IOperateurService operateurService;
	
    
    @Test
	public void addOperateurTest() {
    	when(operateurRepository.save(operateur1)).thenReturn(operateur1);
    	assertNotNull(operateur1);
    	
    	Operateur persisted = operateurService.addOperateur(operateur1);
		assertEquals(operateur1, persisted); 
    	
		System.out.println("add works !");
	}
    
    @Test 
    public void retrieveAllOperateursTest() {
    	when(operateurRepository.findAll()).thenReturn(Stream
    			.of(operateur1,operateur2)
    			.collect(Collectors.toList()));
    	
    	assertEquals(2,operateurService.retrieveAllOperateurs().size());
    	System.out.println("Retrieve operators works !");
    }
    
   
    
    
    @Test 
    public void UpdateOperateurTest() {
    	when(operateurRepository.save(operateur1)).thenReturn(operateur1);
    	assertNotNull(operateur1);
    	assertEquals(operateur1, operateurService.updateOperateur(operateur1));
    	System.out.println("Update works!");
    }
    
    @Test
    public void retrieveOperateurTest() {
    	when(operateurRepository.findById(operateur1.getIdOperateur())).thenReturn(Optional.of(operateur1));
    	assertEquals(operateur1, operateurService.retrieveOperateur(operateur1.getIdOperateur()));
    	System.out.println("Retrieve operator works !");
    }
}