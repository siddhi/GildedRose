package com.gildedrose.items;

import com.gildedrose.items.features.ItemExpiryInterface;
import com.gildedrose.items.features.ItemQualityInterface;
import com.gildedrose.types.BoundedCounter;

public abstract class Item implements ItemQualityInterface, ItemExpiryInterface {

    public String name;
    public int sellIn;
    public BoundedCounter quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = new BoundedCounter(quality, 0, 50);
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality.value();
    }

	public void update() {
		updateQuality(quality);
		sellIn = updateSellIn(sellIn);
		if (sellIn < 0) {
		    updateQualityOfExpiredItem(quality);
		}
	}
}
