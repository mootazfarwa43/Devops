package com.esprit.examen.services;

import org.junit.jupiter.api.Test;

//import static org.junit.Assert.*;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.esprit.examen.entities.CategorieProduit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.text.ParseException;
import java.util.List;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class CategorieProduitImplTest {
	
	@Autowired
	ICategorieProduitService categorieService;
	
	@Test
	public void testAddCategorieProduit() {
	//	List<Stock> stocks = stockService.retrieveAllStocks();
	//	int expected=stocks.size();
		CategorieProduit c = new CategorieProduit((long) 1,"101","phone");
		CategorieProduit savedCategorieProduit= categorieService.addCategorieProduit(c);
		
	//	assertEquals(expected+1, stockService.retrieveAllStocks().size());
		assertNotNull(savedCategorieProduit.getCodeCategorie());
		categorieService.deleteCategorieProduit(savedCategorieProduit.getIdCategorieProduit());
		
	} 
	
	@Test
	public void testDeleteCategorieProduit() {
		CategorieProduit c = new CategorieProduit((long) 2,"102","pc");
		CategorieProduit savedCategorieProduit= categorieService.addCategorieProduit(c);
		categorieService.deleteCategorieProduit(savedCategorieProduit.getIdCategorieProduit());
		assertNull(categorieService.retrieveCategorieProduit(savedCategorieProduit.getIdCategorieProduit()));
	}
	
	@Test
	public void testRetrieveretrieveAllCategorieProduits() throws ParseException {

		List<CategorieProduit> categories = categorieService.retrieveAllCategorieProduits();
		int expectedCategoriesSize = categories.size();
		CategorieProduit categorie = new CategorieProduit((long) 3,"125","souris");
		CategorieProduit categorie2 = categorieService.addCategorieProduit(categorie);
		assertEquals(expectedCategoriesSize + 1, categorieService.retrieveAllCategorieProduits().size());
		categorieService.deleteCategorieProduit(categorie2.getIdCategorieProduit());

	}

}
/*



	
	
	@Test
	public void testAddStock() {
	//	List<Stock> stocks = stockService.retrieveAllStocks();
	//	int expected=stocks.size();
		Stock s = new Stock("stock test",10,100);
		Stock savedStock= stockService.addStock(s);
		
	//	assertEquals(expected+1, stockService.retrieveAllStocks().size());
		assertNotNull(savedStock.getLibelleStock());
		stockService.deleteStock(savedStock.getIdStock());
		
	} 
	
	@Test
	public void testAddStockOptimized() {

		Stock s = new Stock("stock test",10,100);
		Stock savedStock= stockService.addStock(s);
		assertNotNull(savedStock.getIdStock());
		assertSame(10, savedStock.getQte());
		assertTrue(savedStock.getQteMin()>0);
		stockService.deleteStock(savedStock.getIdStock());
		
	} 
	
	@Test
	public void testDeleteStock() {
		Stock s = new Stock("stock test",30,60);
		Stock savedStock= stockService.addStock(s);
		stockService.deleteStock(savedStock.getIdStock());
		assertNull(stockService.retrieveStock(savedStock.getIdStock()));
	}


*/
