package com.esprit.examen.services;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.Stock;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class StockServiceImplTest {
	@Autowired
	IStockService stockService;

	@Test
	@Order(1)
	public void testRetrieveAllStocks() {
	List<Stock> liststock = stockService.retrieveAllStocks();
	Assertions.assertEquals(0, liststock.size());
	}

}