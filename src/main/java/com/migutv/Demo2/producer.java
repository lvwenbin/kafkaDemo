package com.migutv.Demo2;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class producer {

	private final Producer<String,String> producer;
	private final String topic;
	private final Properties pro=new Properties();
	
	public producer(String topic)
	{
	  //pro.put("serializer.class", "Kafka.serializer.StringEncoder");
		pro.put("serializer.class", "kafka.serializer.StringEncoder");
		pro.put("metadata.broker.list", "localhost:9092");
		producer=new Producer<String,String>(new ProducerConfig(pro));
		this.topic=topic;
	}
	
	public void sendSingleMessage(String message)
	{
		
		//producer.send(new KeyedMessage<Integer, String>(topic, message));
		producer.send(new KeyedMessage<String, String>(topic, "first", message));
		System.out.println("message send successfully");
	}
}
