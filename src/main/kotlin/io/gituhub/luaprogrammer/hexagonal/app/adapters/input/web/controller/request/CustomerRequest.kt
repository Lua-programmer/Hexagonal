package io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.controller.request

import jakarta.validation.constraints.NotBlank

data class CustomerRequest(

    @field:NotBlank
    val name: String,

    @field:NotBlank
    var zipcode: String,

    @field:NotBlank
    val cpf: String,
)