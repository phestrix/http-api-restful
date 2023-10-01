package ru.phestrix.httpapirestful.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
        if (customerOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        customerRepository.save(customer);
    }

    public void deleteById(Long customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new IllegalStateException("customer with id" + customerId + "does not exist");
        }
        customerRepository.deleteById(customerId);
    }

    @Transactional
    public void updateCustomer(Long customerId, String name, String email) {
        Customer customer = customerRepository.findById(customerId).
                orElseThrow(() -> new IllegalStateException("customer with id" + customerId + "doesn't exist"));
        if (name != null && name.length() > 0
                && Objects.equals(customer.getName(), name)) {
            customer.setName(name);
        }
        if (email != null && email.length() > 0 &&
                Objects.equals(customer.getEmail(), email)) {
            Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(email);
            if (customerOptional.isPresent()) {
                throw new IllegalStateException("customer with email:" + email + "already exist");
            }
            customer.setEmail(email);
        }
    }
}
