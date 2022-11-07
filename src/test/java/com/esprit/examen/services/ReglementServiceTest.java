package com.esprit.examen.services;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.esprit.examen.entities.Reglement;
import com.esprit.examen.repositories.FactureRepository;
import com.esprit.examen.repositories.ReglementRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = {ReglementServiceImpl.class})
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReglementServiceTest {
    @MockBean
    private ReglementRepository rgrepo;

  
    @Autowired
     ReglementServiceImpl reglementServiceImpl;
    
    
    @MockBean
    private  FactureServiceImpl factureServiceImpl;
@MockBean
private FactureRepository facturerepo;

@Autowired
IReglementService regServ;

    @Test
   public void   testRetrive() {
            ArrayList<Reglement> reglementList = new ArrayList<>();
            when(rgrepo.findAll()).thenReturn(reglementList);
            List<Reglement> actualRetrieveAllRegResult = reglementServiceImpl.retrieveAllReglements();
            assertSame(reglementList, actualRetrieveAllRegResult);
            assertTrue(actualRetrieveAllRegResult.isEmpty());
            verify(rgrepo).findAll();
        }
    
    @Test
    
    public void testAddReg() throws ParseException {
        Reglement reg = new Reglement();
        reg.setDateReglement(new SimpleDateFormat( "yyyyMMdd" ).parse( "20220520" ));
        reg.setFacture(null);
        reg.setIdReglement(1L);
        reg.setMontantPaye((float) 15.500);
        reg.setMontantRestant((float) 0.750);
        reg.setPayee(false);
        assertSame(reg, reglementServiceImpl.addReglement(reg));
        verify(rgrepo).save((Reglement) any());
    }
    
    
   
    
   
}