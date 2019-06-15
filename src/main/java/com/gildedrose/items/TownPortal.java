package com.gildedrose.items;

import com.gildedrose.items.features.ConjuredItem;

public class TownPortal extends Item implements ConjuredItem {
	public TownPortal(int sellIn, int quality) {
		super("Town Portal", sellIn, quality);
	}
}
