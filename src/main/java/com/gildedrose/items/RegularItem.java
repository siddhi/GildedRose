package com.gildedrose.items;

import com.gildedrose.items.features.ItemExpires;
import com.gildedrose.items.features.ItemQualityDegrades;

public class RegularItem extends Item implements ItemExpires, ItemQualityDegrades {
	public RegularItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
}
