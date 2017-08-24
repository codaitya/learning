package com.work.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.Comparator;

public class Unit1Exercise7 {
	public static void main ( String [] args  ) {
		List<Person> people  = Arrays.asList( 
				new Person("Charles", "Dickens", 60) ,
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));
		
		// sort by java 7
		Collections.sort(people, new Comparator<Person> ()
				{
					public int compare (Person p1, Person p2 ) {
						return p1.getLastNAme().compareTo(p2.getLastNAme());
					}
		});
		printall(people);
		
		
		// print all beginning with c 
		printConditionally(people, new Condition () {
			public boolean test ( Person a ) {
				return a.getLastNAme().startsWith("c");
			}
		});
		
	}
	
	
	public static void printConditionally( List <Person> people , Condition c ) {
		for ( Person p : people ) {
			if ( c.test(p)  )
				System.out.println(p.toString());
		}
	}
	
	public static void printbeginningwithC1( List <Person> people , Predicate<Person>  c) {
		for ( Person p : people ) {
			if ( c.test(p)  )
				System.out.println(p.toString());
		}
	}
	

	private static void printall(List<Person> people) {
		for (Person p: people ) {
			System.out.println(p.toString());
		}
	}
	
	@FunctionalInterface
	interface Condition {
		public  boolean test( Person a );
	}
}
