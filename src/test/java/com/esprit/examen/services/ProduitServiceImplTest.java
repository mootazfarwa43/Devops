package com.esprit.examen.services;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Optional;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.CategorieProduitRepository;
import com.esprit.examen.repositories.DetailFactureRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.StockRepository;
import springfox.documentation.spring.data.rest.OptionalDeferencer;
public class ProduitServiceImplTest {
	
	@MockBean
    private CategorieProduitRepository categorieProduitRepository;
    @MockBean
    private ProduitRepository produitRepository;
    @Autowired
    private ProduitServiceImpl produitServiceImpl;
    @MockBean
    private StockRepository stockRepository;
@Test
   public void testRetreiveById(){
	Produit p = new Produit();
	p.setCategorieProduit(null);
	p.setCodeProduit("123");
	p.setDateCreation(null);
	p.setDateDerniereModification(null);
	p.setDetailFacture(null);
	p.setIdProduit(1L);
	p.setLibelleProduit("libelle");
	p.setPrix((float)5.500);
	p.setStock(null);
	Optional<Produit> produits = Optional.of(p);
	when(produitRepository.findById((Long) any())).thenReturn(produits);
	assertSame(p,produitServiceImpl.retrieveProduit(1L));
	verify(produitRepository).findById((Long) any());
	
}
}