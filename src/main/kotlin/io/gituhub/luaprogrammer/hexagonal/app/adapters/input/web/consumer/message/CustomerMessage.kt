package io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.consumer.message

import io.gituhub.luaprogrammer.hexagonal.core.domain.Address

data class CustomerMessage (
    var id: String,

    val name: String,

    var address: Address,

    val cpf: String,

    val isValidCpf: Boolean
)