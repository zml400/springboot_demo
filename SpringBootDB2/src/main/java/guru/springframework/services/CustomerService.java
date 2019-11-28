package guru.springframework.services;

import guru.springframework.domain.Customer;

import java.util.List;

public interface CustomerService {

    Customer saveOrUpdateCustomer();

    void deleteCustomer(Long id);

    List<Customer> listAll();

    Customer getById(Long id);

}
