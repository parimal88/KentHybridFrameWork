package com.kent.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadProperties {
    // It is same like PageObject class. There declaring driver object; here Properties obj.
    Properties prop;
    //Defining a constructor
    public ReadProperties() {
        //File src = new File("./resources/qa.properties");
        File src = new File("./src/test/resources/qa.properties");
        try{
            FileInputStream fis = new FileInputStream(src);
            prop = new Properties();
            prop.load(fis);
        }
        catch (Exception e){
            System.out.println("Exception is :"+ e.getMessage());
        }
    }

    public String getApplicationURL(){
        String url = prop.getProperty("baseURL");
        return url;
    }

    public String getUserName(){
        String userName = prop.getProperty("userName");
        return userName;
    }

    public String getPassword(){
        String password = prop.getProperty("password");
        return password;
    }
}
