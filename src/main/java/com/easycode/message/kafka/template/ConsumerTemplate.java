package com.easycode.message.kafka.template;

import java.util.List;
import java.util.Map;

import com.easycode.message.kafka.consumer.KafkaConsumerSupport;
import com.easycode.message.kafka.consumer.callbackListener.ConsumerCallbackListener;
import com.easycode.message.kafka.consumer.config.KafkaConsumerConfig;

public class ConsumerTemplate {
	
	//消费者客户端
	private KafkaConsumerSupport kafkaConsumerSupport;
	
	//消费者构造函数配置
	private KafkaConsumerConfig config;
	
	public ConsumerTemplate(KafkaConsumerConfig config){
		this.config = config;
	}
	
	/**
	 * 根据不同的groupId及topic构造不同的消费实例
	 */
	private void newConsumerInstance(String[] topic, String groupId){
		
		config.setGroupId(groupId);
		kafkaConsumerSupport = new KafkaConsumerSupport(topic , config);
		
	}
	
	/**
	 * 根据一个主题与消费分组id去实例话一个consumer线程
	 * @param destination
	 * @param groupId
	 * @param consumerCallbackListener
	 */
	public void startConsumerThread(String[] destination, String groupId,ConsumerCallbackListener consumerCallbackListener){
		
		newConsumerInstance(destination , groupId);
		
		Thread consumerThread = new Thread(new ConsumerRunnable(consumerCallbackListener));
		consumerThread.start();
		
	}	
	
	/**
	 * kafka消费线程
	 * @author kongkonghu
	 *
	 */
	protected class ConsumerRunnable implements Runnable {
		
		ConsumerCallbackListener consumerCallbackListener;
		
		public ConsumerRunnable(ConsumerCallbackListener _consumerCallbackListener){
			consumerCallbackListener = _consumerCallbackListener;
		}
		
		
		public void run() {
			while (true) {
				List<Map.Entry<String, String>> messages = kafkaConsumerSupport.receive(100);
				if(messages.size() <= 0){
					continue;
				}
				consumerCallbackListener.afterReceive(messages);
			}
		}

	}
}
