package com.gildedrose.items;

import com.gildedrose.types.BoundedCounter;

public class Item {

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

	void updateSellIn() {
	    sellIn = sellIn - 1;
	}

	void updateQuality() {
	    quality.decrement();
	}

	void updateQualityOfExpiredItem() {
    	quality.decrement();
	}

	public void update() {
		updateQuality();
		updateSellIn();
		if (sellIn < 0) {
		    updateQualityOfExpiredItem();
		}
	}
}
