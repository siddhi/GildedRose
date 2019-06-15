package com.gildedrose.items.features;

public interface ItemExpires extends ItemExpiryInterface {
	default int updateSellIn(int currentSellIn) {
		return currentSellIn - 1;
	}
}
