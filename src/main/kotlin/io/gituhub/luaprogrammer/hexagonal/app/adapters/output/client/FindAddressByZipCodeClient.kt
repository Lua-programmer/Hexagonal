package io.gituhub.luaprogrammer.hexagonal.app.adapters.output.client

import io.gituhub.luaprogrammer.hexagonal.app.adapters.output.client.response.AddressResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    name = "findAddressByZipCodeClient",
    url = "\${programmer.client.address.url}"
)
fun interface FindAddressByZipCodeClient {

    @GetMapping("/{zipcode}")
    fun find(@PathVariable("zipcode") zipCode: String): AddressResponse
}