package com.isra.orders.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "agents")
class Agent(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "agentid")
        var id: Long = 0,

        var name: String?,
        var workingArea: String?,
        var commission: Double?,
        var phone: String?,
        var country: String?,

        @OneToMany(mappedBy = "agent", cascade = [CascadeType.ALL], orphanRemoval = true)
        @JsonIgnoreProperties(value = ["agents"])
        var customers: List<Customer> = ArrayList(),

        @OneToMany(mappedBy = "agent", cascade = [CascadeType.ALL], orphanRemoval = true)
        @JsonIgnoreProperties(value = ["agents"])
        var orders: List<Customer> = ArrayList()
) {
        constructor(name: String?, workingArea: String?, commission: Double?, phone: String?, country: String?)
                : this(0, name, workingArea, commission, phone, country)
}