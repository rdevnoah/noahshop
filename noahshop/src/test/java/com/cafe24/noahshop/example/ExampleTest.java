package com.cafe24.noahshop.example;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class ExampleTest {
	// 테스트 케이스(메소드)끼릴 공유해야 할 변수가 있으면
	// static!!
	private static StringBuilder output = new StringBuilder("");
	
	@BeforeClass
	public static void setUpBefore() {
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public static void tearDownAfter() {
		System.out.println("@AfterClass:" + output.toString());
	}
	
	@Before
	public void setUp() {
		System.out.println("@Before");
	}
	
	@After
	public void tearDown() {
		System.out.println("@After");
	}
	
	@Test
	public void my_K_Test() {
		System.out.println("@Test:K");
		output.append("K");
	}
	
	@Test
	public void myXTest() {
		System.out.println("@Test:X");
		output.append("X");
	}

	@Test
	public void myCTest() {
		System.out.println("@Test:C");
		output.append("C");
	}
	
	
	// 테스트 무시 무시
	@Ignore
	@Test
	public void ignoreTest() {
		assertTrue(false);
	}
	
	@Test
	public void testAssert() {
		assertTrue(true);
		assertFalse(false);
		
		assertNull(null);
		assertNotNull(new Object());
		
		assertEquals(1+2, 3);
		assertEquals(new String("hello"), "hello");
		assertNotEquals(true, false);
		
		assertSame("Hello", "Hello");
		assertNotSame(new Integer(1), new Integer(1));
		
		// asssertThat : is
		assertThat(1+2, is(3));
		assertThat("this is never", is(not("that")));
		
		// assertThat : allof
		assertThat("hello", allOf(startsWith("he"),containsString("lo")));
		
		// assertThat : anyof
		assertThat("hello", anyOf(startsWith("he"),containsString("lo")));
		
		// assertThat : both
		assertThat("ABC", both(containsString("A")).and(containsString("C")));
		
		// assertThat : either
		assertThat("ABC", either(containsString("A")).or(containsString("C")));
		
		// assertThat : everyItem
		assertThat(Arrays.asList("apple", "application", "apply", "apocalypse"), everyItem(startsWith("ap")));
		
		// assertThat : hasItem
		assertThat(Arrays.asList("apple", "banana", "grape", "watermelon"), hasItem(startsWith("ap")));
		
		// fails
		//fail("All Over!!!");
		
	}
}