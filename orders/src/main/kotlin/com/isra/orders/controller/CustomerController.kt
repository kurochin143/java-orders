package com.isra.orders.controller

import com.isra.orders.model.Customer
import com.isra.orders.service.CustomerServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class CustomerController(private val customerServiceImpl: CustomerServiceImpl) {

    @GetMapping("/customer/order")
    fun getCustomersAndTheirOrders(): ResponseEntity<*> {
        val customers = customerServiceImpl.findAll()

        return ResponseEntity(customers, HttpStatus.OK)
    }

    @GetMapping("/customer/name/{custname}")
    fun getCustomerOrders(@PathVariable("custname") name: String): ResponseEntity<*> {
        val customer = customerServiceImpl.findByName(name)

        return ResponseEntity(customer.orders, HttpStatus.OK)
    }

    @PostMapping(value = ["/data/customer/new"], consumes = ["application/json"])
    fun addNewCustomer(@RequestBody customer: Customer): ResponseEntity<*> {
        val outCustomer = customerServiceImpl.save(customer)

        return ResponseEntity(outCustomer, HttpStatus.CREATED)
    }

    @PatchMapping(value = ["/data/customer/update/{custcode}"], consumes = ["application/json"])
    fun updateCustomer(@RequestBody customer: Customer, @PathVariable("custcode") id: Long): ResponseEntity<*> {
        val outCustomer = customerServiceImpl.update(customer, id)

        return ResponseEntity(outCustomer, HttpStatus.OK)
    }

    @DeleteMapping(value = ["/data/customer/delete/{custcode}"])
    fun deleteCustomer(@PathVariable("custcode") id: Long): ResponseEntity<*> {
        val outCustomer = customerServiceImpl.delete(id)

        return ResponseEntity("{}", HttpStatus.OK)
    }


}