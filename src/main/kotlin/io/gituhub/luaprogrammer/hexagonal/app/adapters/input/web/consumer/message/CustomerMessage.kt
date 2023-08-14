package io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.consumer.message

data class CustomerMessage (
    var id: String,

    val name: String,

    var zipCode: String,

    val cpf: String,

    val isValidCpf: Boolean
)