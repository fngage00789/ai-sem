package co.th.ais.sem.hana.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController()
public class ProducerController {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${queue.topic.bp.replicate.in}")
    private String replicateTopicIn;

    @Value("${queue.topic.bp.replicate.confirmation.in}")
    private String replicateConfirmationTopicIn;

    @Value("${queue.topic.bp.replicate.out}")
    private String replicateTopicOut;

    @Value("${queue.topic.bp.replicate.confirmation.out}")
    private String replicateConfirmationTopicOut;

    @PostMapping(path = "/api/esb/producers", consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> esbProducers(@RequestBody String xmlRequest){

        Map<String, String> response = new LinkedHashMap<>();
        ObjectMapper

        try {
            kafkaTemplate.send(replicateConfirmationTopicIn, xmlRequest);
            response.put("status", "success");
        } catch (Exception ex){
            LOGGER.error(ex.getMessage());
            response.put("status", "success");
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
