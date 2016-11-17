package com.easycode.message.kafka.message.manager.impl;

import javax.annotation.Resource;

import com.easycode.message.kafka.message.Message;
import com.easycode.message.kafka.message.manager.MessageManager;
import com.easycode.message.kafka.template.ProducerTemplate;

public class MessageManagerImpl implements MessageManager{
	
	@Resource(name = "producerTemplate")
    private ProducerTemplate producerTemplate;
	
	@Override
	public void sendUserMessage(String topic,Message message) {
		// TODO Auto-generated method stub
		producerTemplate.send(topic, System.currentTimeMillis()+"", message.toString());
	}

}
