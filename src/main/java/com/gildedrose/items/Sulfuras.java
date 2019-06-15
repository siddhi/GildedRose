package com.gildedrose.items;

import com.gildedrose.types.BoundedCounter;

public class Sulfuras extends Item {
	public Sulfuras(int sellIn) {
		super("Sulfuras, Hand of Ragnaros", sellIn, 80);
		quality = new BoundedCounter(80, 80, 80);
	}

	@Override
	void updateQuality() {
	}
	
	@Override
	void updateSellIn() {
	}
	
	@Override
	void updateQualityOfExpiredItem() {
	}
}
