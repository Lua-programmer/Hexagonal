package io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.controller

import io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.controller.mapper.toCustomer
import io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.controller.mapper.toCustomerResponse
import io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.controller.request.CustomerRequest
import io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.controller.response.CustomerResponse
import io.gituhub.luaprogrammer.hexagonal.infra.ports.input.DeleteCustomerByIdInputPort
import io.gituhub.luaprogrammer.hexagonal.infra.ports.input.FindCustomerByIdInputPort
import io.gituhub.luaprogrammer.hexagonal.infra.ports.input.InsertCustomerInputPort
import io.gituhub.luaprogrammer.hexagonal.infra.ports.input.UpdateCustomerInputPort
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(

    private val  insertCustomerInputPort: InsertCustomerInputPort,
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val updateCustomerInputPort: UpdateCustomerInputPort,
    private val deleteCustomerByIdInputPort: DeleteCustomerByIdInputPort,

){

    @PostMapping
    fun insert(
        @RequestBody @Valid customerRequest: CustomerRequest
    ): ResponseEntity<Unit> {
        insertCustomerInputPort.insert(
            customerRequest.toCustomer(),
            customerRequest.zipcode)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/{id}")
    fun findById(
        @PathVariable id: String
    ): ResponseEntity<CustomerResponse> {
        val customer = findCustomerByIdInputPort
            .findById(id)?.toCustomerResponse()
        return ResponseEntity.ok().body(customer)
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: String,
        @RequestBody customerRequest: CustomerRequest
    ): ResponseEntity<Unit> {
        findCustomerByIdInputPort.findById(id)
        val customer = customerRequest.toCustomer()
        id.also { customer.id = it }
        updateCustomerInputPort.update(customer, customerRequest.zipcode)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/{id}")
    fun delete(
        @PathVariable id: String
    ): ResponseEntity<Unit> {
        findCustomerByIdInputPort.findById(id)
        deleteCustomerByIdInputPort.delete(id)
        return ResponseEntity.noContent().build()
    }
}