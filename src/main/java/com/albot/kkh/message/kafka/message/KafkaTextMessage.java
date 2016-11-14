package com.albot.kkh.message.kafka.message;

import com.albot.kkh.message.TextMessage;

public class KafkaTextMessage implements TextMessage {

	private String text;

	
	public String getText() {
		return this.text;
	}

	
	public void setText(String text) {
		this.text = text;
	}

}
