package ir.mjimani.demo.resource;

import ir.mjimani.demo.kafka.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class KafkaResourceImpl implements KafkaResource {

    @Autowired
    private KafkaProducer kafkaProducer;


    @Override
    public ResponseEntity<Boolean> sendMessage() {
        kafkaProducer.send();
        return ResponseEntity.ok().body(true);
    }
}