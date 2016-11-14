package com.easycode.message.kafka.message;

import com.easycode.message.TextMessage;

public class KafkaTextMessage implements TextMessage {

	private String text;

	
	public String getText() {
		return this.text;
	}

	
	public void setText(String text) {
		this.text = text;
	}

}
