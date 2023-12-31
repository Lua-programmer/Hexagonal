package io.gituhub.luaprogrammer.hexagonal.app.adapters.output.persistence.repository

import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.persistence.entity.CustomerEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: MongoRepository<CustomerEntity, String> {

    fun findCustomerEntityById(id: String): CustomerEntity?

    fun deleteCustomerEntityById(id: String)

}