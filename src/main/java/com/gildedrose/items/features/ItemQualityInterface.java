package com.gildedrose.items.features;

import com.gildedrose.types.BoundedCounter;

public interface ItemQualityInterface {
	abstract void updateQuality(BoundedCounter quality);
	abstract void updateQualityOfExpiredItem(BoundedCounter quality);
}