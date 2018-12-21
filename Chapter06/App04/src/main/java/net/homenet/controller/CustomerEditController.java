package net.homenet.controller;

import net.homenet.domain.Customer;
import net.homenet.service.CustomerService;
import net.homenet.service.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/customer/{customerId}")
@SessionAttributes(value = "editCustomer")
public class CustomerEditController {
    @Autowired
    private CustomerService customerService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @RequestMapping(method = GET, value = "/edit")
    public String redirectToEntryForm(@PathVariable int customerId, Model model) throws DataNotFoundException {
        Customer customer = customerService.findById(customerId);
        model.addAttribute("editCustomer", customer);
        return "redirect:enter";
    }

    @RequestMapping(method = GET, value = "/enter")
    public String showEntryForm() {
        return "customer/edit/enter";
    }

    @RequestMapping(method = POST, value = "/enter", params = "_event_proceed")
    public String verify(@Valid @ModelAttribute("editCustomer") Customer customer, Errors errors) {
        if (errors.hasErrors()) {
            return "customer/edit/enter";
        }
        return "redirect:review";
    }

    @RequestMapping(method = GET, value = "/review")
    public String showReview() {
        return "customer/edit/review";
    }

    @RequestMapping(method = POST, value = "/review", params = "_event_revise")
    public String revise() {
        return "redirect:enter";
    }

    @RequestMapping(method = POST, value = "/review", params = "_event_confirmed")
    public String edit(@ModelAttribute("editCustomer") Customer customer) throws DataNotFoundException {
        customerService.update(customer);
        return "redirect:edited";
    }

    @RequestMapping(method = GET, value = "/edited")
    public String showEdited(SessionStatus status) {
        status.setComplete();
        return "customer/edit/edited";
    }
}
