package com.work.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.Comparator;

public class Unit1Exercise {
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
		// sort by lambda
		Collections.sort(people, (p1, p2) -> p1.getLastNAme().compareTo(p2.getLastNAme() ) );
		printall(people);
		
		
		// print all beginning with c 
		printbeginningwithC(people, new Condition () {
			public boolean test ( Person a ) {
				return a.getLastNAme().startsWith("c");
			}
		});
		
		printbeginningwithC(people,  x -> {
			return x.getLastNAme().startsWith("c"); 
		} );
		printbeginningwithC(people,  x -> {
			return x.getLastNAme().startsWith("C"); 
		}
		);
		
		printbeginningwithC(people,  x -> {
			return x.getLastNAme().startsWith("D"); 
		});
		
		performConditionally(people,  x -> {
			return x.getLastNAme().startsWith("D"); } , y -> { System.out.println(y.getLastNAme()); }   );
		
	//	printbeginningwithC ( people, { x-> { return true ; }  );
		
		
		//printall(people);
	}
	
	public static void printbeginningwithC( List <Person> people , Condition c ) {
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
	
	public static void performConditionally( List <Person> people , Predicate<Person> c, Consumer <Person> d ) {
		for ( Person p : people ) {
			if ( c.test(p)  )
				d.accept(p);
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
