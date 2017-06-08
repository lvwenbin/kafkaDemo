package com.migutv.Demo2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

public class consumer {
private final ConsumerConnector consumer;
private final String topic;
public  consumer(String topic)
{
	consumer=Consumer.createJavaConsumerConnector(this.createConsumerConfig());
	this.topic=topic;
}


public ConsumerConfig createConsumerConfig()
{
	Properties pros=new Properties();
	pros.put("zookeeper.connect", "localhost:2181");
	pros.put("zookeeper.session_timeout.ms", "40000");
	pros.put("zookeeper.sync.ms", "200");
	pros.put("auto.commit.interval.ms", "1000");
	pros.put("group.id", "test_group");
	return new ConsumerConfig(pros);
	

}
 public void receive()
 { 
	 HashMap<String, Integer> topicCountMap=new HashMap<String,Integer>();
 topicCountMap.put(this.topic, 1);
	 Map<String, List<KafkaStream<byte[], byte[]>>> kafkaStream=consumer.createMessageStreams(topicCountMap);
	 KafkaStream<byte[], byte[]> messageStream=kafkaStream.get(this.topic).get(0);
	ConsumerIterator<byte[], byte[]> it=messageStream.iterator();
	 while (it.hasNext()) {
		System.out.println(new String(it.next().message()));
	}
 }


 public void run() {
     Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
     topicCountMap.put(topic, new Integer(1));
     Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
     KafkaStream<byte[], byte[]> stream = consumerMap.get(topic).get(0);
     System.out.println(consumerMap);
     ConsumerIterator<byte[], byte[]> it = stream.iterator();
   
     while (it.hasNext()) {
         System.out.println("receive：" + new String(it.next().message()));
         try {
             Thread.sleep(3000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
 }
 

}
