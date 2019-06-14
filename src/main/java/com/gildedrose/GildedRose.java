package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateQuality(items[i]);
            updateSellIn(items[i]);
            if (items[i].sellIn < 0) {
                updateQualityOfExpiredItem(items[i]);
            }
        }
    }

	private void updateQualityOfExpiredItem(Item item) {
		if (item.name.equals("Aged Brie")) {
		    incrementQuality(item);
		} else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
	        item.quality = 0;
	    } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
        }
        else {
        	decrementQuality(item);
		}
	}

	private void updateSellIn(Item item) {
		if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
		    item.sellIn = item.sellIn - 1;
		}
	}

	private void updateQuality(Item item) {
		if (item.name.equals("Aged Brie")) {
		    incrementQuality(item);
		} else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
			incrementQuality(item);
			
            if (item.sellIn < 11) {
                incrementQuality(item);
            }

            if (item.sellIn < 6) {
                incrementQuality(item);
            }
		} else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
        } else {
		    decrementQuality(item);
		}
	}

	private void decrementQuality(Item item) {
		if (item.quality > 0) {
		    item.quality = item.quality - 1;
		}
	}

	private void incrementQuality(Item item) {
		if (item.quality < 50) {
		    item.quality = item.quality + 1;
		}
	}
}