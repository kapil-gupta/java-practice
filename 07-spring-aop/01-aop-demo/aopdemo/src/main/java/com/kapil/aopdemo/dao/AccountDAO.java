package com.kapil.aopdemo.dao;


import org.aspectj.lang.JoinPoint;

public interface AccountDAO {
    public void addAccount();
    public void displayInsideAccountDAO();
    public void setName(String name);
    public String getName();
    public void setServiceCode(String serviceCode);
    public String getServiceCode();

}
