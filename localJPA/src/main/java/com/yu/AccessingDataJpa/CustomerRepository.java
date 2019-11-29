package com.yu.AccessingDataJpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

//继承CrudRepository接口，包含了JPA操作的几种方法
public interface CustomerRepository extends CrudRepository<Customer, Long>{

    List<Customer> findByLastName(String lastName);

    Customer findById(long id);
}
