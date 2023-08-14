package io.gituhub.luaprogrammer.hexagonal.core.domain

data class Address (

    val street: String,
    
    val city: String,

    val state: String,

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Address

        if (street != other.street) return false
        if (city != other.city) return false
        return state == other.state
    }

    override fun hashCode(): Int {
        var result = street.hashCode()
        result = 31 * result + city.hashCode()
        result = 31 * result + state.hashCode()
        return result
    }

    override fun toString(): String {
        return "Address(street='$street', city='$city', state='$state')"
    }


}