package io.gituhub.luaprogrammer.hexagonal.infra.ports.output

fun interface DeleteCustomerByIdOputputPort {

        fun delete(id: String)
}