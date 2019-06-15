package com.gildedrose.items;

public class BackstagePass extends Item {
	public BackstagePass(int sellIn, int quality) {
		super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
	}
	
	@Override
	void updateQuality() {
		quality.increment();
		
        if (sellIn < 11) {
            quality.increment();
        }

        if (sellIn < 6) {
            quality.increment();
        }
	}
	
	@Override
	void updateQualityOfExpiredItem() {
        quality.set(0);
	}
}
