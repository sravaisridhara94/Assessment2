package com.practice.Service;

import com.practice.Model.Product;
import com.practice.Model.PublicAPI;
import org.springframework.http.ResponseEntity;

public interface FetchProductData {

    public Product getDataFromAPI();
}
