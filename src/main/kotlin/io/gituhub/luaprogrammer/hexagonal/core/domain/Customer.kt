package io.gituhub.luaprogrammer.hexagonal.core.domain

data class Customer (

    var id: String,

    val name: String,

    var address: Address,

    val cpf: String,

    val isValidCpf: Boolean
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Customer

        if (id != other.id) return false
        if (name != other.name) return false
        if (address != other.address) return false
        if (cpf != other.cpf) return false
        return isValidCpf == other.isValidCpf
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + address.hashCode()
        result = 31 * result + cpf.hashCode()
        result = 31 * result + isValidCpf.hashCode()
        return result
    }

    override fun toString(): String {
        return "Customer(id='$id', name='$name', address=$address, cpf='$cpf', isValidCpf=$isValidCpf)"
    }

}