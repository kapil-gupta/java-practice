package com.kapil.accounts.service;

import com.kapil.accounts.dto.CustomerDto;

public interface IAccountService {
    void createAccount(CustomerDto customerDto);
}
