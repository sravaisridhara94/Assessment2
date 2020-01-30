package com.practice.Config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    Properties properties = new Properties();

    private ApiConfig apiConfig;


    public ApiConfig getApiConfiguration(){
        apiConfig = new ApiConfig();
        apiConfig.setUrl(properties.getProperty("onlineApi"));
        return apiConfig;
    }

    public void load() throws IOException {

        InputStream propertiesFileStream =
                ApiConfig.class.getClassLoader()
                        .getResourceAsStream("application.properties");
        properties.load(propertiesFileStream);
        propertiesFileStream.close();
    }

}
