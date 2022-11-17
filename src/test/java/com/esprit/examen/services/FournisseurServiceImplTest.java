package com.esprit.examen.services;

import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.FournisseurRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Slf4j
public class FournisseurServiceImplTest {
    @Mock
    FournisseurRepository FournisseurRepo;

    @InjectMocks
    FournisseurServiceImpl FournisseurService;
    //Fournisseur f=Fournisseur.builder().idFournisseur(1L).code("123").libelle("test1")
    //   .categorieFournisseur(null).detailFournisseur(null).factures(null)
    //  .secteurActivites(null).build();
    @Test
    public void retrieveFournisseurTest(){
        Fournisseur f = new Fournisseur(1L,"123","test",null);

        when(FournisseurRepo.findById(1L)).thenReturn(Optional.of(f));
        Fournisseur fournisseur= FournisseurService.retrieveFournisseur((long) 1);
        Assertions.assertNotNull(fournisseur);
        log.info("get ==>"+ fournisseur.toString());
    }
    @Test
    public void addFournisseurTest(){
        Fournisseur f = new Fournisseur(2L,"123","test",null);
        f.setIdFournisseur(2L);
        FournisseurService.addFournisseur(f);
        verify(FournisseurRepo, times(1)).save(f);
        System.out.println(f);
        log.info("add ==>"+ f.toString());
    }

    @Test
    public void retrieveAllFournisseurs()
    {
        List<Fournisseur> Lf = new ArrayList<Fournisseur>() {

            {
                add(new Fournisseur(3L,"123","test",null));
                add(new Fournisseur(4L,"123","test",null));
                add(new Fournisseur(5L,"123","test",null));
            }};


        when(FournisseurService.retrieveAllFournisseurs()).thenReturn(Lf);
        //test
        List<Fournisseur> fournisseurList = FournisseurService.retrieveAllFournisseurs();
        assertEquals(3, fournisseurList.size());
        log.info("retrieve all ==>"+ fournisseurList.toString());

    }

    @Test
    public void deleteFournisseurTest() {
        Fournisseur f = new Fournisseur(6L,"123","test",null);

        FournisseurRepo.save(f);
        FournisseurService.deleteFournisseur(f.getIdFournisseur());
        verify(FournisseurRepo, times(1)).deleteById(f.getIdFournisseur());
        log.info("delete ==>"+ f.toString());

    }


    @Test
    public void updateFournisseurTest() {
        Fournisseur f = new Fournisseur(7L,"123","test",null);
        when(FournisseurRepo.save(f)).thenReturn(f);
        assertNotNull(f);
        assertEquals(f, FournisseurService.addFournisseur(f));
        log.info("update ==>"+ f.toString());
    }

}