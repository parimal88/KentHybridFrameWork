package com.kent.utilities;

import com.kent.pageObjects.HomePage;
import com.kent.testCase.BaseClass;

import java.util.HashMap;
import java.util.Map;

public class FillAddress extends BaseClass {
    HomePage hp = new HomePage(driver);
    public void enterAddress(String firstname, String lastname){
        HashMap<String, String> customerAddress = new HashMap<>();
        customerAddress.put("firstName", firstname);
        customerAddress.put("firstName", lastname);
        fillCustomerAddress(customerAddress);
    }

    public void fillCustomerAddress(Map<String, String> details){
        if(details.containsKey("firstName")){
           hp.setUserName(details.get("firstName"));
        }
    }
}
