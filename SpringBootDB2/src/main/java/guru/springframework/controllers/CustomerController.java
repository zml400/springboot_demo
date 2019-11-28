package guru.springframework.controllers;

import guru.springframework.domain.Customer;
import guru.springframework.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

//    @RequestMapping("/customer")
//    public void getCustomers() {
//        /* return null; */
//    }

    @RequestMapping("/customer/{id}")
    public List<Customer> getCustomers() {
        List<Customer> c = new ArrayList<Customer>();
        c.add(new Customer(11224L, "This is an info",  "History for customer 1"));
        return c;
    }
}
