package com.gildedrose.items;

public class AgedBrie extends Item {
	public AgedBrie(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	@Override
	void updateQuality() {
	    incrementQuality();		
	}
	
	@Override
	void updateSellIn() {
		decrementSellIn();
	}
	
	@Override
	void updateQualityOfExpiredItem() {
		incrementQuality();
	}
}
