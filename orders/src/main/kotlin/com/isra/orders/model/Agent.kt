package com.isra.orders.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import kotlin.jvm.Transient

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

        /**
        @OneToMany(mappedBy = "agent",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
        @JsonIgnoreProperties({"agents"})
        private List<Customers> customers = new ArrayList<>();

        @OneToMany(mappedBy = "agent",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
        @JsonIgnoreProperties({"agents"})
        private List<Orders> orders = new ArrayList<>();
         */

        @OneToMany(mappedBy = "agent",
                cascade = [CascadeType.ALL],
                orphanRemoval = true)
        @JsonIgnoreProperties(value = ["agents"])
        var customers = ArrayList<Customer>()



) {
        constructor(name: String?, workingArea: String?, commission: Double?, phone: String?, country: String?)
                : this(0, name, workingArea, commission, phone, country, null)
}