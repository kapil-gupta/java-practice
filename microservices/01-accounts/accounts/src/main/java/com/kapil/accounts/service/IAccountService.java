package com.kapil.accounts.service;

import com.kapil.accounts.dto.CustomerDto;
import com.kapil.accounts.entity.Account;

public interface IAccountService {
    void createAccount(CustomerDto customerDto);
    CustomerDto findAccountByMobileNumber(String mobileNumber);
    boolean updateAccount(CustomerDto customerDto);
    boolean deleteAccountByMobileNumber(String mobileNumber);
}
