package io.gituhub.luaprogrammer.hexagonal.infra.ports.input

import org.springframework.stereotype.Service

@Service
fun interface DeleteCustomerByIdInputPort {

    fun delete(id: String)
}