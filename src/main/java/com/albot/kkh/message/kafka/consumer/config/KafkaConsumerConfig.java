package com.albot.kkh.message.kafka.consumer.config;

import com.albot.kkh.message.config.Config;

import java.util.Properties;

public class KafkaConsumerConfig extends Config {

	private String bootstrapServers;

	private String groupId;

	private boolean enableAutoCommit = true;

	private long autoCommitIntervalMS = 1000;

	private int sessionTimeoutMS = 1000 * 30;

	private String keyDeserializer;

	private String valueDeserializer;

	public Properties build() {
		Properties props = new Properties();
		props.put("bootstrap.servers", bootstrapServers);
		props.put("group.id", groupId);
		props.put("enable.auto.commit", enableAutoCommit);
		props.put("auto.commit.interval.ms", autoCommitIntervalMS);
		props.put("session.timeout.ms", sessionTimeoutMS);
		props.put("key.deserializer", keyDeserializer);
		props.put("value.deserializer", valueDeserializer);
		return props;
	}

	public String getBootstrapServers() {
		return bootstrapServers;
	}

	public void setBootstrapServers(String bootstrapServers) {
		this.bootstrapServers = bootstrapServers;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public boolean isEnableAutoCommit() {
		return enableAutoCommit;
	}

	public void setEnableAutoCommit(boolean enableAutoCommit) {
		this.enableAutoCommit = enableAutoCommit;
	}

	public long getAutoCommitIntervalMS() {
		return autoCommitIntervalMS;
	}

	public void setAutoCommitIntervalMS(long autoCommitIntervalMS) {
		this.autoCommitIntervalMS = autoCommitIntervalMS;
	}

	public int getSessionTimeoutMS() {
		return sessionTimeoutMS;
	}

	public void setSessionTimeoutMS(int sessionTimeoutMS) {
		this.sessionTimeoutMS = sessionTimeoutMS;
	}

	public String getKeyDeserializer() {
		return keyDeserializer;
	}

	public void setKeyDeserializer(String keyDeserializer) {
		this.keyDeserializer = keyDeserializer;
	}

	public String getValueDeserializer() {
		return valueDeserializer;
	}

	public void setValueDeserializer(String valueDeserializer) {
		this.valueDeserializer = valueDeserializer;
	}

}
