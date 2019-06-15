package com.gildedrose.items;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

	void decrementQuality() {
		if (quality > 0) {
		    quality = quality - 1;
		}
	}
	
	void incrementQuality() {
		if (quality < 50) {
		    quality = quality + 1;
		}
	}

	void clearQuality() {
		quality = 0;
	}

	void decrementSellIn() {
		sellIn = sellIn - 1;
	}

	void updateSellIn() {
		if (!name.equals("Sulfuras, Hand of Ragnaros")) {
		    decrementSellIn();
		}
	}

	void updateQuality() {
		if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
			incrementQuality();
			
	        if (sellIn < 11) {
	            incrementQuality();
	        }
	
	        if (sellIn < 6) {
	            incrementQuality();
	        }
		} else if (name.equals("Sulfuras, Hand of Ragnaros")) {
	    } else {
		    decrementQuality();
		}
	}

	void updateQualityOfExpiredItem() {
		if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
	        clearQuality();
	    } else if (name.equals("Sulfuras, Hand of Ragnaros")) {
	    }
	    else {
	    	decrementQuality();
		}
	}

	public void update() {
		updateQuality();
		updateSellIn();
		if (sellIn < 0) {
		    updateQualityOfExpiredItem();
		}
	}
}
