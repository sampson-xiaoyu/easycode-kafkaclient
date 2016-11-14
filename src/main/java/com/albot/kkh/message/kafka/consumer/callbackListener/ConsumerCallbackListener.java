package com.albot.kkh.message.kafka.consumer.callbackListener;

import java.util.List;
import java.util.Map;

public interface ConsumerCallbackListener {
	
	public void afterReceive(List<Map.Entry<String, String>> messages);
	
}
