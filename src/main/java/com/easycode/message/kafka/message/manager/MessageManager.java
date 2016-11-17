package com.easycode.message.kafka.message.manager;

import com.easycode.message.kafka.message.Message;

public interface MessageManager {
	
	public void sendUserMessage(String topic,Message message);
	
}
