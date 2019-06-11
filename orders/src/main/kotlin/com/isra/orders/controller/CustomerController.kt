package com.isra.orders.controller

import com.isra.orders.service.AgentServiceImpl
import com.isra.orders.service.CustomerServiceImpl
import com.isra.orders.service.OrderServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class CustomerController(
        private val agentServiceImpl: AgentServiceImpl,
        private val customerServiceImpl: CustomerServiceImpl,
        private val orderServiceImpl: OrderServiceImpl
) {

    @GetMapping("/customer/order")
    fun getCustomersAndTheirOrders(): ResponseEntity<*> {
        val customers = customerServiceImpl.findAll()
        customers.forEach {
            it.orders = orderServiceImpl.findAllByCustomerId(it.id)
        }

        return ResponseEntity(customers, HttpStatus.OK)
    }
}