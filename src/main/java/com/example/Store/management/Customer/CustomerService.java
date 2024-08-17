package com.example.Store.management.Customer;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void updateCustomerName(Long id, String name) {
        customerRepository.updateCustomerName(id, name);
    }
}