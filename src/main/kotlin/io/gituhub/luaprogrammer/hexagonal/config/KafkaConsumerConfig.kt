package io.gituhub.luaprogrammer.hexagonal.config

import io.gituhub.luaprogrammer.hexagonal.app.adapters.input.web.consumer.message.CustomerMessage
import org.apache.kafka.clients.consumer.ConsumerConfig.*
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@EnableKafka
@Configuration
class KafkaConsumerConfig {

    @Bean
    fun consumerFactory(): ConsumerFactory<String, CustomerMessage> {
        val props = HashMap<String, Any>()
        props.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(GROUP_ID_CONFIG, "programmer");
        props.put(KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java)
        props.put(VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer::class.java)
        props.put(AUTO_OFFSET_RESET_CONFIG, "earliest");
        return DefaultKafkaConsumerFactory(
            props, StringDeserializer(),
            JsonDeserializer(CustomerMessage::class.java)
        );
    }

    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, CustomerMessage> {
        val factory: ConcurrentKafkaListenerContainerFactory<String, CustomerMessage> =
            ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}