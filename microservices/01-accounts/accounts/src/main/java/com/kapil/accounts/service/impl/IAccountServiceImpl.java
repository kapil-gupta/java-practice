package com.kapil.accounts.service.impl;

import com.kapil.accounts.constants.AccountConstants;
import com.kapil.accounts.dto.AccountDto;
import com.kapil.accounts.dto.CustomerDto;
import com.kapil.accounts.entity.Account;
import com.kapil.accounts.entity.Customer;
import com.kapil.accounts.exceptions.CustomerAlreadyExistsException;
import com.kapil.accounts.exceptions.ResourceNotFoundException;
import com.kapil.accounts.mapper.AccountMapper;
import com.kapil.accounts.mapper.CustomerMapper;
import com.kapil.accounts.repository.AccountRepository;
import com.kapil.accounts.repository.CustomerRepository;
import com.kapil.accounts.service.IAccountService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class IAccountServiceImpl implements IAccountService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.toCustomer( new Customer(), customerDto);
        Optional<Customer> existingCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (existingCustomer.isPresent()) {
            throw  new CustomerAlreadyExistsException("Customer with mobile number "+customerDto.getMobileNumber()+" already present");
        }
        customer.setCreatedBy("Anonymous");
        customer.setUpdatedBy("Anonymous");
        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(LocalDateTime.now());
        Customer savedCustomer = customerRepository.save(customer);
        accountRepository.save(createNewAccount(savedCustomer));

    }

    @Override
    public CustomerDto findAccountByMobileNumber(String mobileNumber) {
        Customer existingCustomer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer","mobileNumber",mobileNumber)
        );
        Account account = accountRepository.findByCustomerId(existingCustomer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account","customerId",existingCustomer.getCustomerId().toString())
        );
        CustomerDto customerDto = CustomerMapper.toCustomerDto(existingCustomer, new CustomerDto());
        customerDto.setAccount(AccountMapper.toAccountDto(account, new AccountDto()));
        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated = false;
        AccountDto accountDto = customerDto.getAccount();

        if(accountDto !=null ) {
            Account account = accountRepository.findById(accountDto.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "AccountNumber", accountDto.getAccountNumber().toString())
            );
            AccountMapper.toAccount(account, accountDto);
            accountRepository.save(account);

            Customer savedCustomer = customerRepository.findById(account.getCustomerId()).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "customerId", account.getCustomerId().toString())
            );

            CustomerMapper.toCustomer(savedCustomer, customerDto);
            customerRepository.save(savedCustomer);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    @Transactional
    public boolean deleteAccountByMobileNumber(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer","mobileNumber",mobileNumber)
        );
        Account account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account","customerId",customer.getCustomerId().toString())
        );
        customerRepository.deleteById(customer.getCustomerId());
        accountRepository.deleteByCustomerId(customer.getCustomerId());
        return true;

    }


    private Account createNewAccount(Customer customer) {
        Account account = new Account();
        account.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        account.setAccountNumber(randomAccNumber);
        account.setCreatedAt(LocalDateTime.now());
        account.setUpdatedAt(LocalDateTime.now());
        account.setUpdatedBy("Anonymous");
        account.setCreatedBy("Anonymous");
        account.setAccountType(AccountConstants.SAVINGS);
        account.setBranchAddress(AccountConstants.ADDRESS);
        return account;
    }
}
