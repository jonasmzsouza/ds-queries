package com.devsuperior.uri2602.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2602.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
