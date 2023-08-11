package io.gituhub.luaprogrammer.hexagonal.core.usecases

import io.gituhub.luaprogrammer.hexagonal.infra.ports.input.DeleteCustomerByIdInputPort
import io.gituhub.luaprogrammer.hexagonal.infra.ports.output.DeleteCustomerByIdOputputPort
import io.gituhub.luaprogrammer.hexagonal.infra.ports.output.FindCustomerByIdOutputPort

class DeleteCustomerByIdUseCase(
    private val customerOutput: FindCustomerByIdOutputPort,
    private val customerByIdOputputPort: DeleteCustomerByIdOputputPort
): DeleteCustomerByIdInputPort {

    override fun delete(id: String) {
        customerOutput.find(id)
        customerByIdOputputPort.delete(id)
    }
}