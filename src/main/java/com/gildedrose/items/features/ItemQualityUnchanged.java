package com.gildedrose.items.features;

import com.gildedrose.types.BoundedCounter;

public interface ItemQualityUnchanged extends ItemQualityInterface {
	default void updateQuality(BoundedCounter quality) {
	}
	
	default void updateQualityOfExpiredItem(BoundedCounter quality) {
	}
}
