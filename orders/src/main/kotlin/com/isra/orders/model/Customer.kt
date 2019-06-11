package com.isra.orders.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import kotlin.jvm.Transient

@Entity
@Table(name = "customers")
class Customer(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "customerid")
        var id: Long = 0,

        @Column(nullable = false)
        var name: String,

        var city: String?,
        var workingArea: String?,
        var country: String?,
        var grade: String?,
        var openingAMT: Double?,
        var receiveAMT: Double?,
        var paymentAMT: Double?,
        var outstandingAMT: Double?,
        var phone: String?,

        @ManyToOne
        @JoinColumn(name = "agentid", nullable = false)
        var agent: Agent,


        @JsonIgnoreProperties(value = ["customers"])
        var orders: List<Order>?
) {

    constructor(
            name: String,
            city: String?,
            workingArea: String?,
            country: String?,
            grade: String?,
            openingAMT: Double?,
            receiveAMT: Double?,
            paymentAMT: Double?,
            outstandingAMT: Double?,
            phone: String?,
            agent: Agent
    ) : this(0, name, city, workingArea, country, grade, openingAMT, receiveAMT, paymentAMT, outstandingAMT, phone, agent, null)

}