package com.gildedrose.types;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoundedCounterTest {
	@Test
	public void testInitialValueIsSet() {
		BoundedCounter i = new BoundedCounter(10, 0, 100);
		assertEquals(10, i.value());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMinCannotBeMoreThanMax() {
		new BoundedCounter(10, 100, 0);		
	}
	
	@Test
	public void testValueCanBeIncremented() {
		BoundedCounter i = new BoundedCounter(10, 0, 100);
		i.increment();
		assertEquals(11, i.value());
	}
	
	@Test
	public void testValueCannotBeIncrementedAboveMax() {
		BoundedCounter i = new BoundedCounter(100, 0, 100);
		i.increment();
		assertEquals(100, i.value());
	}
	
	@Test
	public void testValueCanBeDecremented() {
		BoundedCounter i = new BoundedCounter(10, 0, 100);
		i.decrement();
		assertEquals(9, i.value());
	}
	
	@Test
	public void testValueCannotBeDecrementedBelowMin() {
		BoundedCounter i = new BoundedCounter(0, 0, 100);
		i.decrement();
		assertEquals(0, i.value());
	}
	
	@Test
	public void testValueCanBeSet() {
		BoundedCounter i = new BoundedCounter(10, 0, 100);
		i.set(20);
		assertEquals(20, i.value());
	}

	@Test
	public void testValueCannotBeSetBelowMin() {
		BoundedCounter i = new BoundedCounter(10, 0, 100);
		i.set(-1);
		assertEquals(0, i.value());
	}
	
	@Test
	public void testValueCannotBeSetAboveMax() {
		BoundedCounter i = new BoundedCounter(10, 0, 100);
		i.set(200);
		assertEquals(100, i.value());		
	}
}
