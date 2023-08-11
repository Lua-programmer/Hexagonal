package io.gituhub.luaprogrammer.hexagonal.app.adapters.output

import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.persistence.repository.CustomerRepository
import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.persistence.repository.mapper.CustomerEntityMapper
import io.gituhub.luaprogrammer.hexagonal.core.domain.Customer
import io.gituhub.luaprogrammer.hexagonal.infra.ports.output.InsertCustomerOutputPort

class InsertCustomerAdapter(
    private val customerRepository: CustomerRepository,
    private val customerEntityMapper: CustomerEntityMapper
): InsertCustomerOutputPort{
    override fun insert(customer: Customer) {
        customerRepository.save(customerEntityMapper.toEntity(customer))
    }

}