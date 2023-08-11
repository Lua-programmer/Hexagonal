package io.gituhub.luaprogrammer.hexagonal.core.domain

data class Customer (

    val id: String,

    val name: String,

    var address: Address,

    val cpf: String,

    val isValidCpf: Boolean
)