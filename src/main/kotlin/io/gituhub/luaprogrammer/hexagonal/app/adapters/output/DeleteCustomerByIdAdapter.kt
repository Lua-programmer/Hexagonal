package io.gituhub.luaprogrammer.hexagonal.app.adapters.output

import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.persistence.repository.CustomerRepository
import io.gituhub.luaprogrammer.hexagonal.infra.ports.output.DeleteCustomerByIdOputputPort
import org.springframework.stereotype.Component

@Component
class DeleteCustomerByIdAdapter(
    private val customerRepository: CustomerRepository
): DeleteCustomerByIdOputputPort {
    override fun delete(id: String) {
        customerRepository.deleteCustomerEntityById(id)
    }
}