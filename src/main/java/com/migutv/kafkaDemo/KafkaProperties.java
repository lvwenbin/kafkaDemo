package com.migutv.kafkaDemo;

public interface KafkaProperties {
	 //final static String zkConnect = "192.168.200.217:2181,192.168.200.218:2181,192.168.200.219:2181";
	final static String zkConnect ="localhost:2181";
	    final static String groupId = "group1";
	    //final static String topic = "topic1";
	    final static String topic = "test";
	   // final static String kafkaServerURL = "192.168.200.217:9092,192.168.200.218:9092,192.168.200.219:9092";
	    final static String kafkaServerURL = "9092";
	    final static int kafkaServerPort = 9092;
	    final static int kafkaProducerBufferSize = 64 * 1024;
	    final static int connectionTimeOut = 20000;
	    final static int reconnectInterval = 10000;
	    final static String topic2 = "topic2";
	    final static String topic3 = "topic3";
	    final static String clientId = "SimpleConsumerDemoClient";
}
