package com.kapil.accounts.controller;

import com.kapil.accounts.constants.AccountConstants;
import com.kapil.accounts.dto.AccountDto;
import com.kapil.accounts.dto.CustomerDto;
import com.kapil.accounts.dto.ResponseDto;
import com.kapil.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/account", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class Accounts {

    private final IAccountService iAccountService;
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto){

        iAccountService.createAccount(customerDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));

    }
}
