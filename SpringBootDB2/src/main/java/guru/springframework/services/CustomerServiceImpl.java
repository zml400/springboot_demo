package guru.springframework.services;

import guru.springframework.domain.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(readOnly = false)
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public Customer saveOrUpdateCustomer() {
        System.out.println("CustomerServiceImpl - save or update customer");
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {
        System.out.println("CustomerServiceImpl - deleteCustomer");
    }

    @Override
    public List<Customer> listAll() {
        System.out.println("CustomerServiceImpl - listAll");
        return null;
    }

    @Override
    public Customer getById(Long id) {
        System.out.println("CustomerServiceImpl - getById");
        return null;
    }
}