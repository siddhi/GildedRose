package com.gildedrose.items.features;

import com.gildedrose.types.BoundedCounter;

public interface ItemQualityImproves extends ItemQualityInterface {
	default void updateQuality(BoundedCounter quality) {
		quality.increment();
	}
	
	default void updateQualityOfExpiredItem(BoundedCounter quality) {
		quality.increment();		
	}
}
