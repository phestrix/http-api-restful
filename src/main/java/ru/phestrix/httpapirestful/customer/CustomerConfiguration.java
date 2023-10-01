package ru.phestrix.httpapirestful.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class CustomerConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository) {
        return args -> {
            Customer Johny = new Customer(
                    1L,
                    "Johny",
                    "johnyboy@gmail.com",
                    LocalDate.of(1999, Month.APRIL, 13)
            );
            Customer Mary = new Customer(
                    2L,
                    "Mary",
                    "maryantuanette@gmail.com",
                    LocalDate.of(2000, Month.FEBRUARY, 24)
            );
            repository.saveAll(List.of(Johny, Mary));
        };
    }
}
