package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/customers")
    public ResponseEntity<List<Customer>> handleGetCustomers() {

        List<Customer> customers = customerService.getCustomers();
        return ResponseEntity.ok(customers);

    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/customers", params = {"name"})
    public ResponseEntity<List<Customer>> handleGetCustomerByName(@RequestParam String name) {
        List<Customer> customers = customerService.getCustomersByName(name);
        if (customers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customers);
    }


    @PostMapping(path = "/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }

    @PutMapping(path = "/customers/{id}")
    public ResponseEntity<Customer> editCustomer(@PathVariable int id, @RequestBody Customer customer) {
        customer.setId(id);
        return ResponseEntity.ok(customerService.editCustomer(customer));
    }

    @DeleteMapping(path = "/customers/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
