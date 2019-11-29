package com.yu.AccessingDataJpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class,args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository){
        return (args) -> {
            //保存一些对象
            repository.save(new Customer("Test1","Yu"));
            repository.save(new Customer("Test2","Yu"));
            repository.save(new Customer("Test3","Yu"));
            repository.save(new Customer("Test4","Yu"));

            /* 测试方法*/
            //JPA中提供的方法 findAll
            log.info("Customers found with findAll():");
            log.info("-----------------------");
            for (Customer customer : repository.findAll()){
                log.info(customer.toString());
            }
            log.info("");

            //findById
            Customer customer = repository.findById(1L);
            log.info("Customers found with findById():");
            log.info("-----------------------");
            log.info(customer.toString());
            log.info("");

            //findByLastName
            log.info("Customers found with findByLastName('Yu'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Yu").forEach(yus -> {
                log.info(yus.toString());
            });
            log.info("");


        };

    }




}
