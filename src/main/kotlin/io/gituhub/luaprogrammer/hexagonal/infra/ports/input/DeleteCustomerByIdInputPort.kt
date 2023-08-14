package io.gituhub.luaprogrammer.hexagonal.infra.ports.input

fun interface DeleteCustomerByIdInputPort {

    fun delete(id: String)
}