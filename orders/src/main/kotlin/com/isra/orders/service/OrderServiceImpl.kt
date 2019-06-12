package com.isra.orders.service

import com.isra.orders.model.Order
import com.isra.orders.repository.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service(value = "orderService")
class OrderServiceImpl : OrderService {

    @Autowired
    lateinit var orderRepository: OrderRepository

    override fun findAll(): MutableList<Order> {
        val outOrders = mutableListOf<Order>()
        orderRepository.findAll().toCollection(outOrders)
        return outOrders
    }
}