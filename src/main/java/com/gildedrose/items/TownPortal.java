package com.gildedrose.items;

public class TownPortal extends Item {

	public TownPortal(int sellIn, int quality) {
		super("Town Portal", sellIn, quality);
	}
	
	@Override
	public void updateQuality() {
		decrementQuality();
		decrementQuality();
	}
	
	@Override
	public void updateQualityOfExpiredItem() {
		decrementQuality();
		decrementQuality();		
	}
}
