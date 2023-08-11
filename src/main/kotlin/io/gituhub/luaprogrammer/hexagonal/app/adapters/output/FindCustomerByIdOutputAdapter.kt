package io.gituhub.luaprogrammer.hexagonal.app.adapters.output

import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.persistence.repository.CustomerRepository
import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.persistence.repository.mapper.CustomerEntityMapper
import io.gituhub.luaprogrammer.hexagonal.core.domain.Customer
import io.gituhub.luaprogrammer.hexagonal.infra.ports.output.FindCustomerByIdOutputPort
import java.lang.RuntimeException
import java.util.*

class FindCustomerByIdOutputAdapter(
    private val customerRepository: CustomerRepository,
    private val customerEntityMapper: CustomerEntityMapper
): FindCustomerByIdOutputPort {
    override fun find(id: String): Customer? {
        val customerEntity = customerRepository.findById(id)
        return customerEntity.map { customerEntityMapper.toDomain(it) }
            .orElseThrow { RuntimeException("Customer not found") }
    }
}