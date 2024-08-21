package com.example.Store.management.Customer;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void updateCustomerName(Long id, String name) {
        // پیدا کردن مشتری با ID مشخص
        Optional<Customer> customerOptional = customerRepository.findById(id);

        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            // به‌روزرسانی نام مشتری
            customer.setName(name);
            // ذخیره تغییرات
            customerRepository.save(customer);
        } else {
            // اینجا میتونیم بگیم که مشتری با ایدی مشخص شده پیدا نشده.
            throw new RuntimeException("Customer with ID " + id + " not found.");
        }
    }
}
