package io.gituhub.luaprogrammer.hexagonal.app.adapters.output

import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.persistence.repository.CustomerRepository
import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.persistence.repository.mapper.toEntity
import io.gituhub.luaprogrammer.hexagonal.core.domain.Customer
import io.gituhub.luaprogrammer.hexagonal.infra.ports.output.UpdateCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class UpdateCustomerAdapter(
    private val customerRepository: CustomerRepository,
): UpdateCustomerOutputPort {
    override fun update(customer: Customer) {
        customer.toEntity().let { customerEntity ->
            customerRepository.save(customerEntity!!)
        }
    }
}