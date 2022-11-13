package com.esprit.examen.services;

import com.esprit.examen.repositories.OperateurRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;
import com.esprit.examen.services.IOperateurService;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class OperateurServcieTest {
	
	@MockBean
	private OperateurRepository operateurRepository;
	
	private Operateur operateur1 = new Operateur("Med Amine","Khaili","123456");
	private Operateur operateur2 = new Operateur("Flen","Fouleni","123456");
	  
	@Autowired
	IOperateurService operateurService;
	
    
    @Test
	public void addOperateurTest() {
    	when(operateurRepository.save(operateur1)).thenReturn(operateur1);
    	assertNotNull(operateur1);
    	
    	Operateur persisted = operateurService.addOperateur(operateur1);
		assertEquals(operateur1, persisted); 
    	
		System.out.println("Add operator works !");
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
    	System.out.println("Update operator works !");
    }
    
    @Test
    public void retrieveOperateurTest() {
    	when(operateurRepository.findById(operateur1.getIdOperateur())).thenReturn(Optional.of(operateur1));
    	assertEquals(operateur1, operateurService.retrieveOperateur(operateur1.getIdOperateur()));
    	System.out.println("Retrieve operator works !");
    }
}