package com.backbase.training.targeting.restcollector;

/**
 * Created by marcio on 04/08/16.
 */
public class CustomerInfo {
    private String customerName;
    private String customerClass;
    private double annualIncome;

    public CustomerInfo(String name, String customerClass, double income) {
        this.customerName = name;
        this.customerClass = customerClass;
        this.annualIncome = income;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerClass() {
        return customerClass;
    }

    public void setCustomerClass(String customerClass) {
        this.customerClass = customerClass;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }
}
