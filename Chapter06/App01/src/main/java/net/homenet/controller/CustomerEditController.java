package net.homenet.controller;

import net.homenet.domain.Customer;
import net.homenet.service.CustomerService;
import net.homenet.service.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/customer/{customerId}")
@SessionAttributes(value = "editCustomer")
public class CustomerEditController {
    @Autowired
    private CustomerService customerService;

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

    //# 1./customer/{customerId}/edited 로 Redirect 하는 경우
    //@RequestMapping(method = POST, value = "/review", params = "_event_confirmed")
    //public String edit(@ModelAttribute("editCustomer") Customer customer) throws DataNotFoundException {
    //    customerService.update(customer);
    //    return "redirect:edited";
    //}

    //# 2./customer 로 Redirect 하는 경우
    @RequestMapping(method = POST, value = "/review", params = "_event_confirmed")
    public String edit(@ModelAttribute("editCustomer") Customer customer
        , SessionStatus status
        , RedirectAttributes redirectAttributes) {

        customerService.update(customer);
        status.setComplete();
        redirectAttributes.addFlashAttribute("editCustomer", customer);
        return "redirect:/customer";
    }

    @RequestMapping(method = GET, value = "/edited")
    public String showEdited(SessionStatus status) {
        status.setComplete();
        return "customer/edit/edited";
    }
}
