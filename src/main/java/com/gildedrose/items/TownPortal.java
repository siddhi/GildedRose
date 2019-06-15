package com.gildedrose.items;

public class TownPortal extends Item {

	public TownPortal(int sellIn, int quality) {
		super("Town Portal", sellIn, quality);
	}
	
	@Override
	public void updateQuality() {
		quality.decrement();
		quality.decrement();
	}
	
	@Override
	public void updateQualityOfExpiredItem() {
		quality.decrement();
		quality.decrement();		
	}
}
