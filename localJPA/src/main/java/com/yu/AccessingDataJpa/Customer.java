package com.yu.AccessingDataJpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
    JPA 实体类
 */
@Entity //声明这个类为实体类
public class Customer {

    @Id //指定为主键
    @GeneratedValue(strategy = GenerationType.AUTO) //自动增长
    private Long id;
    private String firstName;
    private String lastName;


    protected Customer(){}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
