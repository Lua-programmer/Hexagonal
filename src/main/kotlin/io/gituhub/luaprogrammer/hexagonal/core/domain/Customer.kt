package io.gituhub.luaprogrammer.hexagonal.core.domain

data class Customer (

    val id: String,

    val name: String,

    val address: Address,

    val cpf: String,

    val isValidCpf: Boolean
)