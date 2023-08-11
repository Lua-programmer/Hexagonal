package io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.controller

import io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.controller.mapper.CustomerMapper
import io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.controller.request.CustomerRequest
import io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.controller.response.CustomerResponse
import io.gituhub.luaprogrammer.hexagonal.infra.ports.input.FindCustomerByIdInputPort
import io.gituhub.luaprogrammer.hexagonal.infra.ports.input.InsertCustomerInputPort
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController {

    private lateinit var  insertCustomerInputPort: InsertCustomerInputPort
    private lateinit var findCustomerByIdInputPort: FindCustomerByIdInputPort
    private lateinit var customerMapper: CustomerMapper

    @PostMapping
    fun insert(@RequestBody @Valid customerRequest: CustomerRequest): ResponseEntity<Unit> {
        val customer = customerMapper.toCustomer(customerRequest)
        insertCustomerInputPort.insert(customer, customerRequest.zipcode)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String): ResponseEntity<CustomerResponse> {
        val customer = findCustomerByIdInputPort.findById(id)
        val response = customerMapper.toCustomerResponse(customer!!)
        return ResponseEntity.ok().body(response)
    }
}