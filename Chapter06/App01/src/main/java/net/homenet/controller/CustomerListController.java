package net.homenet.controller;

import net.homenet.domain.Customer;
import net.homenet.service.CustomerService;
import net.homenet.service.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class CustomerListController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = GET, value = "/")
    public String home() {
        //noinspection SpringMVCViewInspection
        return "forward:/customer";
    }

    @RequestMapping(method = GET, value = "/customer")
    public String showAllCustomers(Model model) {
        List<Customer> customers = customerService.findAll();

        //# DataNotFoundException 예외를 발생하기 위한 Customer 객체 추가
        Customer invalidCustomer = new Customer("mousesd", "aaa@bbb.ccc", new Date(), 3);
        invalidCustomer.setId(5);

        customers.add(invalidCustomer);
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @RequestMapping(method = GET, value = "/customer/{customerId}")
    public String showCustomerDetail(@PathVariable int customerId, Model model) throws DataNotFoundException {
        Customer customer = customerService.findById(customerId);
        model.addAttribute("customer", customer);
        return "customer/detail";
    }

    @ExceptionHandler(DataNotFoundException.class)
    public String handleException() {
        return "customer/notfound";
    }
}
