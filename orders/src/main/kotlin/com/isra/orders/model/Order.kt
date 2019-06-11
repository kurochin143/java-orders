package com.isra.orders.model

import javax.persistence.*

@Entity
@Table(name = "orders")
class Order(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "orderid")
        var id: Long = 0,

        var amount: Double?,
        var advanceAmount: Double?,

        @ManyToOne
        @JoinColumn(name = "customerid", nullable = false)
        var customer: Customer,

        @ManyToOne
        @JoinColumn(name = "agentid", nullable = false)
        var agent: Agent,

        var description: String?
) {

    constructor(amount: Double?, advanceAmount: Double?, customer: Customer, agent: Agent, description: String?)
            : this(0, amount, advanceAmount, customer, agent, description)
}