package com.isra.orders.repository

import com.isra.orders.model.Agent
import org.springframework.data.repository.CrudRepository

interface AgentRepository : CrudRepository<Agent, Long>