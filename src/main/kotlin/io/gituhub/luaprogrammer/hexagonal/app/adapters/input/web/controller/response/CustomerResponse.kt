package io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.controller.response

data class CustomerResponse(

    val name: String,

    var address: AddressResponse,

    val cpf: String,

    val isValidCpf: Boolean
)