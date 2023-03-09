package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties = new Properties();



    static{

        try {
            FileInputStream configFile = new FileInputStream("configuration.properties");

            properties.load(configFile);
            configFile.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("there is an error in the configreader class");
        }

    }

    public static String getProperty(String key) {


        return properties.getProperty(key);//getProperty method is coming from Properties class, different from our method name
    }

}

