package com.easycode.message.kafka.template;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.easycode.message.config.Config;


public class ProducerTemplate  {

    private Producer<String, String> producer;

    public ProducerTemplate(Config config) {
        this.producer = new KafkaProducer(config.build());
    }

    public void send(String topic, String key, String value) {
        producer.send(new ProducerRecord<String, String>(topic, key, value));
    }
}
