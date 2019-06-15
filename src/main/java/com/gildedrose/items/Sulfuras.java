package com.gildedrose.items;

import com.gildedrose.items.features.LegendaryItem;
import com.gildedrose.types.BoundedCounter;

public class Sulfuras extends Item implements LegendaryItem {
	public Sulfuras(int sellIn) {
		super("Sulfuras, Hand of Ragnaros", sellIn, 80);
		quality = new BoundedCounter(80, 80, 80);
	}
}
