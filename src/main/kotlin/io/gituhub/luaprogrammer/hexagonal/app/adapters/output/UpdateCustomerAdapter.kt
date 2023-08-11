package io.gituhub.luaprogrammer.hexagonal.app.adapters.output

import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.persistence.repository.CustomerRepository
import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.persistence.repository.mapper.CustomerEntityMapper
import io.gituhub.luaprogrammer.hexagonal.core.domain.Customer
import io.gituhub.luaprogrammer.hexagonal.infra.ports.output.UpdateCustomerOutputPort

class UpdateCustomerAdapter(
    private val customerRepository: CustomerRepository,
    private val customerEntityMapper: CustomerEntityMapper
): UpdateCustomerOutputPort {
    override fun update(customer: Customer) {
        val customerEntity = customerEntityMapper.toEntity(customer)
        customerRepository.save(customerEntity)
    }
}