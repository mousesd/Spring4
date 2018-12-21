package net.homenet.service;

import net.homenet.domain.Customer;

import java.util.List;

@SuppressWarnings("unused")
public interface CustomerService {
    List<Customer> findAll();
    Customer findById(int id) throws DataNotFoundException;
    Customer register(Customer customer);
    void update(Customer customer) throws DataNotFoundException;
    void delete(int id) throws DataNotFoundException;
}
