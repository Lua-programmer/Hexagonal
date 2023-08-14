package io.gituhub.luaprogrammer.hexagonal.infra.ports.output

interface SendCPFforValidationOutputPort {

    fun send(cpf: String)
}