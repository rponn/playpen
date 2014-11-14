package com.ravi.sampleapp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ravi.sampleapp.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByName(String name);
}