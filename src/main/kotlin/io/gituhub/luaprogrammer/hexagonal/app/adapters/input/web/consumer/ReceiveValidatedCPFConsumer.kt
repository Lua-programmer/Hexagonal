package io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.consumer

import io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.consumer.message.CustomerMessage
import io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.consumer.message.mapper.CustomerMessageMapper
import io.gituhub.luaprogrammer.hexagonal.infra.ports.input.UpdateCustomerInputPort
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ReceiveValidatedCPFConsumer(
    private val updateCustomerInputPort: UpdateCustomerInputPort,
    private val customerMessageMapper: CustomerMessageMapper
) {

    @KafkaListener(topics = ["tp-cpf-validated"], groupId = "programmer")
    fun receive(customerMessage: CustomerMessage) {
        val customer = customerMessageMapper.toCustomer(customerMessage)
        updateCustomerInputPort.update(customer, customerMessage.zipCode)
    }
}