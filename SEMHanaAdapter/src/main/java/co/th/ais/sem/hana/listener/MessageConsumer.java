package co.th.ais.sem.hana.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @KafkaListener(topics = "${queue.topic.bp.replicate.out}")
    public void replicateOut(String message) {
        System.out.println("Received message: " + message);
    }

    @KafkaListener(topics = "${queue.topic.bp.replicate.confirmation.out}")
    public void replicateConfirmationOut(String message) {
        System.out.println("Received message: " + message);
    }

}
