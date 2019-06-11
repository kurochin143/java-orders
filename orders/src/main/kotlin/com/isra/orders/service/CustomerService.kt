package com.isra.orders.service

import com.isra.orders.model.Customer

interface CustomerService {

    fun findAll(): MutableList<Customer>
}