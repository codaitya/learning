package com.work.lambda;

public class Greeter {
	
	public void greet (Greeting greeting) {
		greeting.perform();
	}

	public static void main ( String ars[] ) {
		Greeter g = new Greeter();
		Greeting someGreeting = new HelloWorldGreeting();
		HelloWorldGreeting someMoreGreeting = new HelloWorldGreeting();
		g.greet(someGreeting);
		g.greet(someMoreGreeting);
		g.greet( new HelloWorldGreeting() );
		Greeting greettmp = () -> { System.out.println("Hello from greettmp"); } ;
		greettmp.perform();
		g.greet(greettmp);
		g.greet( () -> {
			System.out.println("fds");
		});
		
		Greeting innerClassGreeting = new Greeting() {
			public void perform () {
				System.out.println("Greetings from inner class");
			}
		};
		innerClassGreeting.perform();
		Add t = (x, y) -> {System.out.println(x+y); };
	}
}

interface Add {
	public void add (int a, int b);
}
