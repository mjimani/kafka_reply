package ir.mjimani.demo.kafka;

import ir.mjimani.demo.protos.AddressBookProtos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, byte[]> kafkaTemplate;

    @Value(value = "${kafka.topic}")
    private String topic;

    public void send() {
        AddressBookProtos.Person person = AddressBookProtos.Person
                .newBuilder()
                .setId(1)
                .setName("MohammadJavadImani")
                .setEmail("mjimani.ir@gmail.com")
                .build();
        AddressBookProtos.AddressBook addressBook = AddressBookProtos.AddressBook
                .newBuilder()
                .addPeople(person)
                .build();
        kafkaTemplate.send(topic, addressBook.toByteArray());
    }
}