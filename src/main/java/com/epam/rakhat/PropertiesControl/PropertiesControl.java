package com.epam.rakhat.PropertiesControl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesControl {
    private static final Properties PROPERTIES = new Properties();

    public PropertiesControl(String fileName){

        InputStream is = PropertiesControl.class.getClassLoader().getResourceAsStream(fileName);
        try {
            PROPERTIES.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key){
        return PROPERTIES.getProperty(key);
    }

    public int getIntProperty(String key){
        String property = PROPERTIES.getProperty(key);
        return Integer.parseInt(property);
    }
}
