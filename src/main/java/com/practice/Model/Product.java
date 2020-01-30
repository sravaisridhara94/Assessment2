package com.practice.Model;

import java.util.Date;

// S.O.L.I.D (Single Responsibility)
//Below class handles only products related information.
// productId -> Unique Identifier of product
// productName -> Name of product
// goLiveDate -> When should the product be in live
// brandName -> Which brand does the product belong to

public class Product{
    private String productId;
    private String productName;
    private String brandName;

    //Singleton Design Pattern Implemented.
    private static Product product = null;

    private Product(){}

    public static Product getProductInstance(){
        if(product == null) {
            product = new Product();
        }
        return product;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }


}
