package com.backbase.training.targeting.restcollector;

import org.glassfish.jersey.internal.inject.Custom;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by marcio on 04/08/16.
 */
public class CustomerInfoProvider {

    public static CustomerInfoProvider instance;

    static {
        instance = new CustomerInfoProvider();
    }

    private Map<String,CustomerInfo> data;

    public static CustomerInfoProvider getInstance() {
        return instance;
    }

    public CustomerInfoProvider() {
         data = new HashMap<>();
         populateData();
    }

    private void populateData() {
        data.put("admin",new CustomerInfo("admin","Premium",150000));
        data.put("manager",new CustomerInfo("manager","Standard",40000));
        data.put("ivan",new CustomerInfo("ivan","Gold",350000));
        data.put("jane",new CustomerInfo("jane","Premium",60000));
        data.put("john",new CustomerInfo("john","Gold",50000));
        data.put("mike",new CustomerInfo("mike","Standard",80000));
        data.put("pablo",new CustomerInfo("pablo","Premium",800000));
    }

    public CustomerInfo getCustomerInfo(String name) {
        return data.get(name);
    }


}
