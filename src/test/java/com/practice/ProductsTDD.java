package com.practice;

import com.practice.Model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public final class ProductsTDD {

    //Checking if Product starts with 'P' using JUnit (Test Driven Development)
    private Product product = Product.getProductInstance();
    private char productId_startswith= 'P';

    @Test
    public void check_product_id_validity(){
        product.setProductId("P12345");
        Assertions.assertEquals(productId_startswith , product.getProductId().charAt(0));
    }

}
