package com.gildedrose.types;

public class BoundedCounter {

	private int value;
	private int max;
	private int min;
	
	public BoundedCounter(int initial, int min, int max) {
		if (min > max) {
			throw new IllegalArgumentException("min cannot be more than max");
		}
		this.value = initial;
		this.max = max;
		this.min = min;
	}

	public void decrement() {
		value --;
		if (value < min) {
			value = min;
		}
	}

	public void increment() {
		value ++;
		if (value > max) {
			value = max;
		}
	}

	public void set(int newValue) {
		value = newValue;
		if (value < min) {
			value = min;
		}
		if (value > max) {
			value = max;
		}
	}

	public int value() {
		return value;
	}
}
