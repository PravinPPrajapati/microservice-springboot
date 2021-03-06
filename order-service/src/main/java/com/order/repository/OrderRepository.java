package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.objects.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
