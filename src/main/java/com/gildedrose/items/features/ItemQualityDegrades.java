package com.gildedrose.items.features;

import com.gildedrose.types.BoundedCounter;

public interface ItemQualityDegrades extends ItemQualityInterface {
	default void updateQuality(BoundedCounter quality) {
		quality.decrement();
	}
	
	default void updateQualityOfExpiredItem(BoundedCounter quality) {
		quality.decrement();		
	}
}
