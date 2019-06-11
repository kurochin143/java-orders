package com.isra.orders.service

import com.isra.orders.model.Order

interface OrderService {

    fun findAll(): MutableList<Order>
}