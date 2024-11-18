package com.tut.graphql.Graphql_tut.repository;

import com.tut.graphql.Graphql_tut.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
}
