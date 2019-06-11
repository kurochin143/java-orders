package com.isra.orders.service

import com.isra.orders.model.Customer

interface CustomerService {

    fun findAll(): MutableList<Customer>
    fun findByName(name: String): Customer
    fun save(customer: Customer): Customer
    fun update(customer: Customer, id: Long): Customer
    fun delete(id: Long): Customer

}