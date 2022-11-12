package tn.esprit.rh.achat.tests;

import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.IStockService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class StockServiceImplTest {
	@Autowired
	IStockService stockService;

	/*@Test
	@Order(1)
	public void testRetrieveAllStocks() {
	List<Stock> allStocks = stockService.retrieveAllStocks();
	assertEquals(0,allStocks.size());
	}
	
	@Test
	@Order(2)
	public void testAddStock() {
	Stock s = new Stock("stock test",10,100);
	Stock savedStock= stockService.addStock(s);
	assertEquals(s.getLibelleStock(), savedStock.getLibelleStock());
	}
	@Test
	@Order(3)
	public void testRetrieveStock() {
	Stock stock = stockService.retrieveStock(1L);
	assertEquals(1L, stock.getIdStock().longValue());
	}
	@Test
	@Order(4)
	public void testDeleteStock() {
	stockService.deleteStock(1L);
	assertNull(stockService.retrieveStock(1L));
	}*/
}