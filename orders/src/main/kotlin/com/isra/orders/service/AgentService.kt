package com.isra.orders.service

import com.isra.orders.model.Agent

interface AgentService {

    fun findAll(): MutableList<Agent>
    fun findAgentById(id: Long): Agent
    fun findAgentByName(name: String): Agent
    fun delete(id: Long): Agent
    fun save(agent: Agent): Agent
    fun update(agent: Agent, id: Long): Agent

}