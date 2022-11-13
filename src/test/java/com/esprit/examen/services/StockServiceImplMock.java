package com.esprit.examen.services;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;
import com.esprit.examen.services.StockServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StockServiceImplMock {
    @Mock
    StockRepository stockRepository;

    @InjectMocks
    StockServiceImpl stockServiceImpl;

    Stock s= new Stock("test",100,10);
    List<Stock> listStocks = new ArrayList<Stock>() {
        {
            add(new Stock("test1",100,10));
            add(new Stock("test2",200,20));
        }
    };
    
    @Test
    public void testAddstock() {
        Mockito.when(stockRepository.save(s)).thenReturn(s);
        Stock s1 = stockServiceImpl.addStock(s);
        Assertions.assertNotNull(s1);

    }
    @Test
    public void testRetrieveStock() {
        Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
        Stock s1 = stockServiceImpl.retrieveStock(new Long(2));
        Assertions.assertNotNull(s1);
    }

    @Test
    public void testAllRetrieveStock() {
        Mockito.when(stockRepository.findAll()).thenReturn(listStocks);
        List<Stock> lStocks = stockServiceImpl.retrieveAllStocks();
        Assertions.assertNotNull(lStocks);
    }

   

}