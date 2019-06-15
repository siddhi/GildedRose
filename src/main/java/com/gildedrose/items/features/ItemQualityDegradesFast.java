package com.gildedrose.items.features;

import com.gildedrose.types.BoundedCounter;

public interface ItemQualityDegradesFast extends ItemQualityInterface {
	default void updateQuality(BoundedCounter quality) {
		quality.decrement();
		quality.decrement();
	}
	
	default void updateQualityOfExpiredItem(BoundedCounter quality) {
		quality.decrement();		
		quality.decrement();
	}
}
