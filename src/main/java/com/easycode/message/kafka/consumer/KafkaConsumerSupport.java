package com.easycode.message.kafka.consumer;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.easycode.message.config.Config;

public class KafkaConsumerSupport {

	private Consumer<String, String> consumer;

	public KafkaConsumerSupport(String[] destination, Config config) {
		consumer = new KafkaConsumer<>(config.build());
		consumer.subscribe(Arrays.asList(destination));
	}

	public List<Map.Entry<String, String>> receive(long timeout) {
		List<Map.Entry<String, String>> list = new ArrayList<>();
		ConsumerRecords<String, String> records = consumer.poll(timeout);
		for (ConsumerRecord<String, String> record : records) {
			list.add(new AbstractMap.SimpleEntry<String, String>(record.key(), record.value()));
		}
		return list;
	}

	public void close() {
		consumer.close();
	}

}
