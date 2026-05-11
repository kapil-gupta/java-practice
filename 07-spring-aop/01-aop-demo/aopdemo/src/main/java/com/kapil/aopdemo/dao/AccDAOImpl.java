package com.kapil.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;

    private MembershipDAO membershipDAO;

    @Override
    public void addAccount() {
        System.out.println(getClass()+" addAccount called   ");
    }

    @Override
    public void displayInsideAccountDAO() {
        System.out.println(getClass()+" displayInsideAccountDAO called   ");
    }

    @Override
    public void setName(String name) {

        System.out.println(" SetName Called ");
        this.name = name;
    }

    @Override
    public String getName() {
        System.out.println(" GetName Called ");
        return this.name;
    }

    @Override
    public void setServiceCode(String serviceCode) {
        System.out.println(" SetServiceCode Called ");
        this.serviceCode = serviceCode;
    }

    @Override
    public String getServiceCode() {
        System.out.println(" GetServiceCode Called ");
        return this.serviceCode;
    }
}
