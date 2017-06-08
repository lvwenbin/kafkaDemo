package com.migutv.Demo2;

public class TestKafka {

	public static void main(String[] args) {
		long t1=System.currentTimeMillis();
		
		
			new producer("test").sendSingleMessage("kafka performance test");
			
			
		
		
		new consumer("test").receive();
		System.out.println(System.currentTimeMillis()-t1);

	}

}
