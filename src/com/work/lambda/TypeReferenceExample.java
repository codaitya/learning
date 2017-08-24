package com.work.lambda;

public class TypeReferenceExample {

	public static void main ( String args [] ) {
		doSomething dto = (s) -> {return s.length();};
		doSomething dto2 = (s) -> s.length() + 1;
		System.out.println(dto.perform("fdf"));
		System.out.println(dto2.perform("fdf"));
		
	}
	
	
	
	
	
	public interface doSomething {
		int  perform (String s ) ;
	}
}
