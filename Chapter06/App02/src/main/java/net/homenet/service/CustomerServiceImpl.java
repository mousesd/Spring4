package net.homenet.service;

import net.homenet.domain.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {
    private int nextId = -1;
    private Map<Integer, Customer> customers = new HashMap<>();

    @PostConstruct
    public void initializeCustomer() {
        nextId = 1;
        register(new Customer("철수", "chulsoo@aa.bb.cc", getDate("19750101"), 1));
        register(new Customer("영희", "younghee@aa.bb.cc", getDate("19760202"), 1));
        register(new Customer("민수", "minsoo@aa.bb.cc", getDate("19770303"), 1));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer findById(int id) throws DataNotFoundException {
        if (!customers.containsKey(id)) {
            throw new DataNotFoundException();
        }
        return customers.get(id);
    }

    @Override
    public Customer register(Customer customer) {
        customer.setId(nextId++);
        customers.put(customer.getId(), customer);
        return customer;
    }

    @Override
    public void update(Customer customer) throws DataNotFoundException {
        if (!customers.containsKey(customer.getId())) {
            throw new DataNotFoundException();
        }
        customers.put(customer.getId(), customer);
    }

    @Override
    public void delete(int id) throws DataNotFoundException {
        if (!customers.containsKey(id)) {
            throw new DataNotFoundException();
        }
        customers.remove(id);
    }

    private Date getDate(String dateString) {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        try {
            return df.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format");
        }
    }
}
