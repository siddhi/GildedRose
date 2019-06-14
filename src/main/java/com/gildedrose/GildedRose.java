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
		    item.incrementQuality();
		} else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
	        item.clearQuality();
	    } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
        }
        else {
        	item.decrementQuality();
		}
	}

	private void updateSellIn(Item item) {
		if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
		    item.decrementSellIn();
		}
	}

	private void updateQuality(Item item) {
		if (item.name.equals("Aged Brie")) {
		    item.incrementQuality();
		} else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
			item.incrementQuality();
			
            if (item.sellIn < 11) {
                item.incrementQuality();
            }

            if (item.sellIn < 6) {
                item.incrementQuality();
            }
		} else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
        } else {
		    item.decrementQuality();
		}
	}
}