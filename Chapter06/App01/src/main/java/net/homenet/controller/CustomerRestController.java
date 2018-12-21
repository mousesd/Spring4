package net.homenet.controller;

import net.homenet.domain.Customer;
import net.homenet.service.CustomerService;
import net.homenet.service.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/api/customer")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String register(@RequestBody Customer customer) {
        customerService.register(customer);
        return "OK";
    }

    @RequestMapping(method = GET, value = "/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Customer findById(@PathVariable int customerId) throws DataNotFoundException {
        return customerService.findById(customerId);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleException(DataNotFoundException e) {
        return "customer is not found";
    }
}
