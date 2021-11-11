package ir.mjimani.demo.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import ir.mjimani.demo.config.KafkaConfig;
import ir.mjimani.demo.protos.AddressBookProtos;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;


@Component
public class KafkaConsumer {

    @KafkaListener(topics = KafkaConfig.TOPIC_NAME, containerFactory = "byteArrayKafkaListenerContainerFactory")
    public void byteArrayListener(byte[] bytes) throws InvalidProtocolBufferException {
        AddressBookProtos.AddressBook addressBook = AddressBookProtos.AddressBook.parseFrom(bytes);
        AddressBookProtos.Person person = addressBook.getPeople(0);
        System.out.println("Received Message in group myGroupId: " + person.getId());
        System.out.println("Received Message in group myGroupId: " + person.getName());
        System.out.println("Received Message in group myGroupId: " + person.getEmail());
    }

}