package com.example.demo.dao;


import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


/**
 * This is the class that will encapsulate the data related logic
 */
@Component
public class CustomerDAO {

    @Autowired
    CustomerRepository customerRepository;


    public List<Customer> findAllCustomers() {

        List<Customer> customers = customerRepository.findAll();

        return customers;
    }

    public Optional<Customer> findByCustomerId(int id) {

        return customerRepository.findById(id);
    }

    public List<Customer> findByName(String name) {
        return customerRepository.findByNameIgnoreCase(name);
    }


    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }


}
