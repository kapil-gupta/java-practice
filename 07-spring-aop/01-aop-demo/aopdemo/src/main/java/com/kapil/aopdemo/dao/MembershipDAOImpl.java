package com.kapil.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public void addAccount() {
        System.out.println(getClass()+"  addAccount called   ");
    }

    @Override
    public void displayInsideMembershipDAO() {
        System.out.println(getClass()+"  displayInsideMembershipDAO called   ");
    }
}
