package com.isra.orders.repository

import com.isra.orders.model.Order
import org.springframework.data.repository.CrudRepository

interface OrderRepository : CrudRepository<Order, Long>