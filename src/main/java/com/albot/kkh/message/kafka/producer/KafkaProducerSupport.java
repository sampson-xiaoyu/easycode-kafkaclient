package com.albot.kkh.message.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.albot.kkh.message.config.Config;

public class KafkaProducerSupport {

	private String destination;
	private Producer<String, String> producer;

	public KafkaProducerSupport(String destination, Config config) {
		this.destination = destination;
		producer = new KafkaProducer<>(config.build());
	}

	public void send(String key, String value) {
		producer.send(new ProducerRecord<String, String>(destination, key, value));
	}

	public void close() {
		producer.close();
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDestination() {
		return destination;
	}

}
