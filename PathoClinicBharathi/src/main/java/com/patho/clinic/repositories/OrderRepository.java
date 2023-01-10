package com.patho.clinic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patho.clinic.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
