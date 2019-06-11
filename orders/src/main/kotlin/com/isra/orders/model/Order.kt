package com.isra.orders.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "orders")
class Order {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var orderid: Long = 0

        var amount: Double? = null
        var advanceAmount: Double? = null

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "customerid", nullable = false)
        @JsonIgnore
        var customer: Customer? = null

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "agentid", nullable = false)
        @JsonIgnore
        var agent: Agent? = null

        var description: String? = null

        constructor()

        constructor(amount: Double?, advanceAmount: Double?, customer: Customer?, agent: Agent?, description: String?) {
                this.amount = amount
                this.advanceAmount = advanceAmount
                this.customer = customer
                this.agent = agent
                this.description = description
        }


}