package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer> {

    public List<Customer> findByNameIgnoreCase(String name);

}
