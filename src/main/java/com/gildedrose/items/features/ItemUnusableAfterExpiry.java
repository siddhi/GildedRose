package com.gildedrose.items.features;

import com.gildedrose.types.BoundedCounter;

public interface ItemUnusableAfterExpiry extends ItemQualityInterface {
	default void updateQualityOfExpiredItem(BoundedCounter quality) {
		quality.set(0);		
	}
}
