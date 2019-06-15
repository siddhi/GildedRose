package com.gildedrose.items;

public class AgedBrie extends Item {
	public AgedBrie(int sellIn, int quality) {
		super("Aged Brie", sellIn, quality);
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
