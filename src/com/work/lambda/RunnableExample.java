package com.work.lambda;

public class RunnableExample {
	
	public static void main ( String args [] ) {
		Thread t = new Thread ( new Runnable () {

			@Override
			public void run() {
				System.out.println("My new thread");
				
			}
			
		});
		t.run();
		
		Thread t1 = new Thread ( () ->  { System.out.println("Hello World"); }) ;
		t1.run();
	}
	
}
