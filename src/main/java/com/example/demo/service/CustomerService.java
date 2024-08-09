package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This is the class that will implement all the business logic of Customer related services
 */
@Service
public class CustomerService {


    @Autowired
    CustomerDAO customerDAO;

    public List<Customer> getCustomers() {

        return customerDAO.findAllCustomers();
    }

    public Customer getCustomerById(int id) {

        Optional<Customer> optCustomer = customerDAO.findByCustomerId(id);
        if (optCustomer.isEmpty()) {
            throw new RuntimeException("Customer by id : " + id + " not found");
        } else {
            return optCustomer.get();
        }
    }

    public List<Customer> getCustomersByName(String name) {
        return customerDAO.findByName(name);

    }

    public Customer saveCustomer(Customer customer) {
        return customerDAO.saveCustomer(customer);
    }

    public Customer editCustomer(Customer customer) {
        Optional<Customer> existingCustomer = customerDAO.findByCustomerId(customer.getId());
        if (existingCustomer.isEmpty()) {
            throw new RuntimeException("Customer by id: " + customer.getId() + " not found");
        } else {
            return customerDAO.saveCustomer(customer);
        }
    }

    public void deleteCustomer(int id) {
        customerDAO.deleteById(id);
    }


}
