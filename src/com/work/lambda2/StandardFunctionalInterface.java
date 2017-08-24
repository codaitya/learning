package com.work.lambda2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.work.lambda.Person;

public class StandardFunctionalInterface {

	public static void main(String[] args) {
		
		List<Person> people  = Arrays.asList( 
				new Person("Charles", "Dickens", 60) ,
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45) );
		
	performConditionally(people,  x -> {
			return x.getLastNAme().startsWith("D"); } , y -> { System.out.println(y.getLastNAme()); } );
	performConditionally(people,  x -> {
			return true; } , y -> { System.out.println(y.getLastNAme()); }   );

	}
	
	public static void performConditionally( List <Person> people , Predicate<Person> c, Consumer <Person> d ) {
		for ( Person p : people ) {
			if ( c.test(p)  )
				d.accept(p);
		}
	}

}
