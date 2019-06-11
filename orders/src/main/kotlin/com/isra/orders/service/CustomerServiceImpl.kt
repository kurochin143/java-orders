package com.isra.orders.service

import com.isra.orders.model.Customer
import com.isra.orders.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service(value = "customerService")
class CustomerServiceImpl : CustomerService {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    override fun findAll(): MutableList<Customer> {
        val outCustomers = mutableListOf<Customer>()
        customerRepository.findAll().toCollection(outCustomers)
        return outCustomers
    }


}