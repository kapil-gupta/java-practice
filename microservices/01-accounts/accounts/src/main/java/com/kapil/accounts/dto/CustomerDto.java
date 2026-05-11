package com.kapil.accounts.dto;

import com.kapil.accounts.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CustomerDto {
    private String name;
    private String email;
    private String mobileNumber;
    private AccountDto account;
}
