package com.kapil.accounts.mapper;

import com.kapil.accounts.dto.CustomerDto;
import com.kapil.accounts.entity.Customer;

public class CustomerMapper {
    public static CustomerDto toCustomerDto(Customer customer, CustomerDto customerDto) {
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        customerDto.setName(customer.getName());
        return customerDto;
    }
    public  static Customer toCustomer(Customer customer, CustomerDto customerDto) {
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        customer.setName(customerDto.getName());
        return customer;
    }
}
