package com.easycode.message.kafka.message.manager.impl;

import com.easycode.commons.json.JSONUtils;
import com.easycode.message.kafka.message.Message;
import com.easycode.message.kafka.message.manager.MessageManager;
import com.easycode.message.kafka.template.ProducerTemplate;

public class MessageManagerImpl implements MessageManager{
	
    private ProducerTemplate producerTemplate;
	
	@Override
	public void sendUserMessage(String topic,Message message) {
		// TODO Auto-generated method stub
		producerTemplate.send(topic, System.currentTimeMillis()+"", JSONUtils.toJSON(message));
	}

	public ProducerTemplate getProducerTemplate() {
		return producerTemplate;
	}

	public void setProducerTemplate(ProducerTemplate producerTemplate) {
		this.producerTemplate = producerTemplate;
	}
	
	
}
