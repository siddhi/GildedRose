package com.gildedrose.items;

public class BackstagePass extends Item {
	public BackstagePass(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	@Override
	void updateQuality() {
		incrementQuality();
		
        if (sellIn < 11) {
            incrementQuality();
        }

        if (sellIn < 6) {
            incrementQuality();
        }
	}
	
	@Override
	void updateSellIn() {
		decrementSellIn();
	}
	
	@Override
	void updateQualityOfExpiredItem() {
        clearQuality();
	}
}
