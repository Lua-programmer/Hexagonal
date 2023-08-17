package io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.consumer

import io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.consumer.message.CustomerMessage
import io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.consumer.message.mapper.toCustomer
import io.gituhub.luaprogrammer.hexagonal.infra.ports.input.UpdateCustomerInputPort
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ReceiveValidatedCPFConsumer(
    private val updateCustomerInputPort: UpdateCustomerInputPort,
) {

    @KafkaListener(topics = ["tp-cpf-validated"], groupId = "programmer")
    fun receive(customerMessage: CustomerMessage) {
        updateCustomerInputPort.update(customerMessage.toCustomer(), customerMessage.zipCode)
    }
}