package com.isra.orders.service

import com.isra.orders.model.Agent
import com.isra.orders.repository.AgentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityNotFoundException

@Service(value = "agentService")
class AgentServiceImpl : AgentService {

    @Autowired
    lateinit var agentRepository: AgentRepository

    override fun findAll(): MutableList<Agent> {
        val outAgents = mutableListOf<Agent>()
        agentRepository.findAll().toCollection(outAgents)
        return outAgents
    }

    override fun findAgentById(id: Long): Agent {
        return agentRepository.findById(id)
                .orElseThrow { EntityNotFoundException(id.toString()) }
    }

    override fun findAgentByName(name: String): Agent {
        agentRepository.findAll().forEach {
            if (it.name == name) {
                return@findAgentByName it
            }
        }

        throw EntityNotFoundException("Agent $name not found!")
    }

    override fun delete(id: Long): Agent {
        val agent = agentRepository.findById(id)
                .orElseThrow { EntityNotFoundException(id.toString()) }
        agentRepository.deleteById(id)

        return agent
    }

    @Transactional
    override fun save(agent: Agent): Agent {
        val newAgent = Agent(agent.name, agent.workingArea, agent.commission, agent.phone, agent.country)

        return agentRepository.save(newAgent)
    }

    override fun update(agent: Agent, id: Long): Agent {
        val currentAgent = agentRepository.findById(id)
                .orElseThrow { EntityNotFoundException(id.toString()) }

        currentAgent.name = agent.name

        if (agent.workingArea != null) currentAgent.name = agent.name
        if (agent.commission != null) currentAgent.commission = agent.commission
        if (agent.phone != null) currentAgent.phone = agent.phone
        if (agent.country != null) currentAgent.country = agent.country

        return agentRepository.save(currentAgent)
    }
}