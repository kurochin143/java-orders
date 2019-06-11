package com.isra.orders.service

import com.isra.orders.model.Customer
import com.isra.orders.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityNotFoundException

@Service(value = "customerService")
class CustomerServiceImpl : CustomerService {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    override fun findAll(): MutableList<Customer> {
        val outCustomers = mutableListOf<Customer>()
        customerRepository.findAll().toCollection(outCustomers)
        return outCustomers
    }

    override fun findByName(name: String): Customer {
        customerRepository.findAll().forEach {
            if (it.name == name) {
                return@findByName it
            }
        }

        throw EntityNotFoundException("Customer $name not found!")
    }

    @Transactional
    override fun save(customer: Customer): Customer {
        val newCustomer = Customer(
                customer.name,
                customer.city,
                customer.workingArea,
                customer.country,
                customer.grade,
                customer.openingAMT,
                customer.receiveAMT,
                customer.paymentAMT,
                customer.outstandingAMT,
                customer.phone,
                customer.agent
        )

        return customerRepository.save(newCustomer)
    }

    override fun update(customer: Customer, id: Long): Customer {
        val currentCustomer = customerRepository.findById(id)
                .orElseThrow { EntityNotFoundException(id.toString()) }

        currentCustomer.name = customer.name
        if (customer.city != null) currentCustomer.city = customer.city
        if (customer.workingArea != null) currentCustomer.workingArea = customer.workingArea

        // TODO

        return customerRepository.save(currentCustomer)
    }

    override fun delete(id: Long): Customer {
        val currentCustomer = customerRepository.findById(id)
                .orElseThrow { EntityNotFoundException(id.toString()) }

        customerRepository.deleteById(id)

        return currentCustomer
    }

}