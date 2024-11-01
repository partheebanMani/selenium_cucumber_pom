package com.partheeban.utility;

import lombok.SneakyThrows;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaUtility {

    private static KafkaUtility instance;
    Producer<String, String> producer = null;

    private KafkaUtility() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092"); // Replace with your Kafka broker
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<>(properties);
    }


    private static KafkaUtility getInstance() {

        if (instance == null) {
            instance = new KafkaUtility();
        }
        return instance;
    }

    @SneakyThrows
    public void sendKafkaMessages(String topic, String key, String value) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
        producer.send(record);
    }

    public void closeProducer() {
        if (producer != null) {
            producer.close();
            System.out.println("Kafka producer closed.");
        }
    }


}
