package io.gituhub.luaprogrammer.hexagonal.app.adapters.output

import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.persistence.repository.CustomerRepository
import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.persistence.repository.mapper.toEntity
import io.gituhub.luaprogrammer.hexagonal.core.domain.Customer
import io.gituhub.luaprogrammer.hexagonal.infra.ports.output.InsertCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class InsertCustomerAdapter(
    private val customerRepository: CustomerRepository,
): InsertCustomerOutputPort{

    override fun insert(customer: Customer) {
         customer.toEntity().let { customerEntity ->
            customerRepository.save(customerEntity!!)
        }
    }

}