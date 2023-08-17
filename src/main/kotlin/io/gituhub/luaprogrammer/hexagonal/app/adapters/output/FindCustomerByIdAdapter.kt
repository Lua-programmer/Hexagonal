package io.gituhub.luaprogrammer.hexagonal.app.adapters.output

import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.persistence.repository.CustomerRepository
import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.persistence.repository.mapper.toDomain
import io.gituhub.luaprogrammer.hexagonal.core.domain.Customer
import io.gituhub.luaprogrammer.hexagonal.infra.ports.output.FindCustomerByIdOutputPort
import org.springframework.stereotype.Component

@Component
class FindCustomerByIdAdapter(
    private val customerRepository: CustomerRepository,
): FindCustomerByIdOutputPort {
    override fun find(id: String): Customer? {
        val customerEntity = customerRepository.findCustomerEntityById(id)
            ?.toDomain()
        return customerEntity ?: throw RuntimeException("Customer not found")
    }
}