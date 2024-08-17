package com.example.Store.management.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Modifying
    @Query("UPDATE Customer c SET c.name = :name WHERE c.id = :id")
    void updateCustomerName(@Param("id") Long id, @Param("name") String name);
//    void addCustomer(Customer customer);
//    void updateCustomerName(Long id, String name);
//    void deleteCustomerById(int customerId);
//    Customer findCustomerById(int customerId);


}