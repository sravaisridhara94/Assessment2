package com.practice.Helper;

import com.practice.Model.Product;
import com.practice.Model.PublicAPI;

public class ConvertorClass {

    private Product product = Product.getProductInstance();
    public Product mapper(PublicAPI publicAPI){
        return product;
    }

}
