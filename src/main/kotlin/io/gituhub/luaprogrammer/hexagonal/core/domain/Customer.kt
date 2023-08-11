package io.gituhub.luaprogrammer.hexagonal.core.domain

data class Customer (

    var id: String,

    val name: String,

    var address: Address,

    val cpf: String,

    val isValidCpf: Boolean
)