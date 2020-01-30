package com.practice.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.Config.ApiConfig;
import com.practice.Helper.ConvertorClass;
import com.practice.Model.Product;
import com.practice.Model.PublicAPI;
import com.practice.framework.RestTemplateFactory;
import io.reactivex.Observer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class FetchProductDataImpl implements FetchProductData  {

    private final RestTemplateFactory restTemplateFactory =
            RestTemplateFactory.INSTANCE;

    private final HttpHeaders headers;
    private final ObjectMapper objectMapper;
    private final ApiConfig config;
    private ConvertorClass convertorClass;
    private final Logger logger = LoggerFactory.getLogger(FetchProductDataImpl.class);

    public FetchProductDataImpl(ApiConfig config) {
        this.config = config;
        objectMapper = new ObjectMapper();
        headers = new HttpHeaders();
        headers.add("Content Type", String.format("Application/Json"));
        headers.setContentType(MediaType.APPLICATION_JSON);
        convertorClass = new ConvertorClass();
    }

    @Override
    public Product getDataFromAPI() {
        try {
            RestTemplate client = restTemplateFactory.getInstance("PublicAPI");
            PublicAPI api= client.getForObject(config.getUrl(), PublicAPI.class);
            return convertorClass.mapper(api);
        } catch (Exception e) {
            logger.info("Exception occured while fetching data from api");
            return null;
        }
    }



}
