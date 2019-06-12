package com.isra.orders.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "customers")
class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var customerid: Long = 0

        @Column(nullable = false)
        var name: String? = null

        var city: String? = null
        var workingArea: String? = null
        var country: String? = null
        var grade: String? = null
        var openingAMT: Double? = null
        var receiveAMT: Double? = null
        var paymentAMT: Double? = null
        var outstandingAMT: Double? = null
        var phone: String? = null

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "agentid", nullable = false)
        @JsonIgnoreProperties(value = ["customers", "hibernateLazyInitializer"])
        var agent: Agent? = null

        @OneToMany(mappedBy = "customer", cascade = [CascadeType.ALL], orphanRemoval = true)
        @JsonIgnoreProperties(value = ["customers"])
        var orders: List<Order> = ArrayList()

        constructor()

        constructor(name: String?,
                    city: String?,
                    workingArea: String?,
                    country: String?,
                    grade: String?,
                    openingAMT: Double?,
                    receiveAMT: Double?,
                    paymentAMT: Double?,
                    outstandingAMT: Double?,
                    phone: String?,
                    agent: Agent?) {
                this.name = name
                this.city = city
                this.workingArea = workingArea
                this.country = country
                this.grade = grade
                this.openingAMT = openingAMT
                this.receiveAMT = receiveAMT
                this.paymentAMT = paymentAMT
                this.outstandingAMT = outstandingAMT
                this.phone = phone
                this.agent = agent
        }


}