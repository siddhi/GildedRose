package com.gildedrose.items.features;

public interface ItemNeverExpires extends ItemExpiryInterface {
	default int updateSellIn(int currentSellIn)  {
		return currentSellIn;
	}
}
