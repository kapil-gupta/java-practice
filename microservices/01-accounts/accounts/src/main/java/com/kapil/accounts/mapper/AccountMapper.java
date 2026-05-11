package com.kapil.accounts.mapper;

import com.kapil.accounts.dto.AccountDto;
import com.kapil.accounts.entity.Account;

public class AccountMapper {
    public  static AccountDto toCustomerDto(Account account, AccountDto accountDto) {
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setAccountType(account.getAccountType());
        accountDto.setBranchAddress(account.getBranchAddress());
        return accountDto;
    }
    public  static  Account toCustomer(Account account, AccountDto accountDto) {
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setAccountType(accountDto.getAccountType());
        account.setBranchAddress(accountDto.getBranchAddress());
        return account;
    }
}
