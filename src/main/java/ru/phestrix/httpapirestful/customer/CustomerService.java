package ru.phestrix.httpapirestful.customer;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class CustomerService {
    public List<Customer> getCustomers() {
        return List.of(
                new Customer(
                        1L,
                        "Johny",
                        "johnyboy@gmail.com",
                        LocalDate.of(1999, Month.APRIL, 13)
                )
        );
    }
}
