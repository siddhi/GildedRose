package com.gildedrose.items;

import com.gildedrose.items.features.ItemExpires;
import com.gildedrose.items.features.ItemUnusableAfterExpiry;
import com.gildedrose.types.BoundedCounter;

public class BackstagePass extends Item implements ItemExpires, ItemUnusableAfterExpiry {
	public BackstagePass(int sellIn, int quality) {
		super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
	}
	
	public void updateQuality(BoundedCounter quality) {
		quality.increment();
		
        if (sellIn < 11) {
            quality.increment();
        }

        if (sellIn < 6) {
            quality.increment();
        }
	}
}
