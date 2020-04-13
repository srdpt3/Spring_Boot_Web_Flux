package com.dustin.flux_demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StockPrice
{
    private String company;
    private String price;
    private  String change;
    private String value;
    private String status;

}
