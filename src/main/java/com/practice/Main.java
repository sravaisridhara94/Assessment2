package com.practice;

import com.practice.Config.ApiConfig;
import com.practice.Config.Configuration;
import com.practice.Service.FetchProductData;
import com.practice.Service.FetchProductDataImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String args[]){
        ApiConfig apiConfig = new ApiConfig();
        FetchProductData fetchProductData = new FetchProductDataImpl(apiConfig);
        ExecutorService e = Executors.newFixedThreadPool(10);
        List<Runnable> runnables = new ArrayList<>();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(String.format("Brand Name : %s",fetchProductData.getDataFromAPI().getBrandName()));
                System.out.println(String.format("Product ID : %s",fetchProductData.getDataFromAPI().getProductId()));
                System.out.println(String.format("Product Name : %s",fetchProductData.getDataFromAPI().getProductName()));
            }
        };

        e.execute(runnable);
        e.shutdown();


    }

}
