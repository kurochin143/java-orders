package com.isra.orders.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "agents")
class Agent {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var agentid: Long = 0

        var name: String? = null
        var workingArea: String? = null
        var commission: Double? = null
        var phone: String? = null
        var country: String? = null

        @OneToMany(mappedBy = "agent", cascade = [CascadeType.ALL], orphanRemoval = true)
        @JsonIgnoreProperties(value = ["agents"])
        var customers: List<Customer> = ArrayList()

        @OneToMany(mappedBy = "agent", cascade = [CascadeType.ALL], orphanRemoval = true)
        @JsonIgnoreProperties(value = ["agents"])
        var orders: List<Order> = ArrayList()

        constructor()

        constructor(name: String?, workingArea: String?, commission: Double?, phone: String?, country: String?) {
                this.name = name
                this.workingArea = workingArea
                this.commission = commission
                this.phone = phone
                this.country = country
        }


}