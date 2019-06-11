package com.isra.orders.service

import com.isra.orders.model.Order

interface OrderService {

    fun findAllByCustomerId(customerId: Long): MutableList<Order>
}