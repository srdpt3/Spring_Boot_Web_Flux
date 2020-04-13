package com.dustin.flux_demo.controller;


import com.dustin.flux_demo.util.Util;
import lombok.AllArgsConstructor;
import com.dustin.flux_demo.model.StockPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import com.dustin.flux_demo.service.StockPriceService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class Controller {
    private List<StockPrice> stockPriceList = new ArrayList<>();

    @Autowired
    StockPriceService service;

    @Autowired
    Util utilities;

    @PostConstruct
    public void initializeStockObjects() {

        for(int i = 0; i < 10; i++){
            StockPrice stock1 = new StockPrice("회사"+i,
                    utilities.getRandomDoubleBetweenRange(1000, 5000), utilities.getRandomDoubleBetweenRange(5, 15),
                    utilities.getRandomDoubleBetweenRange(1000, 5000), utilities.getStatus());
            stockPriceList.add(stock1);
        }


//        StockPrice stock2 = new StockPrice("회사2",
//                utilities.getRandomDoubleBetweenRange(1000, 5000), utilities.getRandomDoubleBetweenRange(5, 15), utilities.getRandomDoubleBetweenRange(1000, 5000), utilities.getStatus());
//
//        StockPrice stock3 = new StockPrice("회사3",
//                utilities.getRandomDoubleBetweenRange(1000, 5000), utilities.getRandomDoubleBetweenRange(5, 15), utilities.getRandomDoubleBetweenRange(1000, 5000), utilities.getStatus());
//        StockPrice stock4 = new StockPrice("회사3",
//                utilities.getRandomDoubleBetweenRange(1000, 5000), utilities.getRandomDoubleBetweenRange(5, 15), utilities.getRandomDoubleBetweenRange(1000, 5000), utilities.getStatus());
//
//
//        stockPriceList.add(stock2);
//        stockPriceList.add(stock3);
//        stockPriceList.add(stock4);

    }



    @RequestMapping(path="/stockprice", method= RequestMethod.GET, produces= MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<List<StockPrice>> getStockPrice() {
        System.out.println(("StockPrice"));
        return service.getStockPriceData(stockPriceList);
    }
}
