package com.gildedrose.items;

import com.gildedrose.items.features.ItemExpires;
import com.gildedrose.items.features.ItemQualityImproves;

public class AgedBrie extends Item implements ItemExpires, ItemQualityImproves {
	public AgedBrie(int sellIn, int quality) {
		super("Aged Brie", sellIn, quality);
	}
}
