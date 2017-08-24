package com.work.lambda2;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;

public class ExceptionHandlingExample {
	
	public static void doaction ( int [] nums, IntUnaryOperator t , Consumer<Integer> c ) {
		for ( int i : nums ) {
			c.accept(t.applyAsInt(i));
			//c.( t.applyAsInt(i) ) ;
		}
	}
	
	public static void dootheraction ( int [] nums,  BiConsumer<Integer,Integer> c ) {
		for ( int i : nums ) {
			c.accept(i, i);
			//c.( t.applyAsInt(i) ) ;
		}
	}
	
	public static void dootheraction2 ( int [] nums,  int key, BiConsumer<Integer,Integer> c ) {
		for ( int i : nums ) {
			c.accept(i, key);
			//c.( t.applyAsInt(i) ) ;
		}
	}
	public static void main ( String [] args ) {
		int [] nums = {1,2,3,4};
		int key = 3;
		
		doaction ( nums , i->  i*key , x -> System.out.println(x)  );
		doaction ( nums , i->  i+key , x -> System.out.println(x)  );
		dootheraction ( nums, (i, j) -> System.out.println(i + key) );
		 
		dootheraction2 ( nums, 0, (i, j) ->
		{ 
			try {
					System.out.println(i / j);
		}
			catch (ArithmeticException e ) {
				System.out.println("An arithmetic exception occured");
			}
		});
		
		//key = 0;
		//dootheraction ( nums, (i, j) -> System.out.println(i / key) );
		IntUnaryOperator t  = (i) -> i*key;
		
		
	}
}
