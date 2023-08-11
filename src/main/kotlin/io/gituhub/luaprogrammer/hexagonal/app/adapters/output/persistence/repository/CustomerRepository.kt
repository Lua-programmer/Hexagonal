package io.gituhub.luaprogrammer.hexagonal.app.adapters.output.persistence.repository

import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.persistence.entity.CustomerEntity
import org.springframework.data.mongodb.repository.MongoRepository

interface CustomerRepository: MongoRepository<CustomerEntity, String> {

    fun findCustomerEntityById(id: String): CustomerEntity?
}