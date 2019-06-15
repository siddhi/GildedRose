package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackstagePass;
import com.gildedrose.items.Item;
import com.gildedrose.items.Sulfuras;
import com.gildedrose.items.TownPortal;

public class GildedRoseTest {
	@Test
	public void testGildedRoseDelegatesToItemForUpdate() {
		Item mockItem = Mockito.mock(Item.class);
		GildedRose app = new GildedRose(new Item[] { mockItem });
		app.updateQuality();
		Mockito.verify(mockItem).update();
	}

	@Test
	public void testGildedRoseUpdatesAllItems() {
		Item item1 = Mockito.mock(Item.class);
		Item item2 = Mockito.mock(Item.class);
		GildedRose app = new GildedRose(new Item[] { item1, item2 });
		app.updateQuality();
		Mockito.verify(item1).update();
		Mockito.verify(item2).update();
	}
	
    @Test
    public void testQualityIsBoundedBetweenZeroAndFifty() {
    	String[] items = new String[] { 
    			"mouse", "Aged Brie", "Sulfuras, Hand of Ragnaros",
    			"Backstage passes to a TAFKAL80ETC concert", "Town Portal"
    	};
    	for(int itemIndex=0; itemIndex<items.length; itemIndex++) {
    		for(int sellIn=-2; sellIn<100; sellIn++) {
    			for(int quality=0; quality<=50; quality++) {
    				GildedRose app = loadItems(items[itemIndex], sellIn, quality);
    				app.updateQuality();
    				assertTrue(app.items[0].quality >= 0);
    				assertTrue(app.items[0].quality <= 50);
    			}
    		}
    	}
    }

    GildedRose loadItems(String name, int sellIn, int quality) {
    	Item item; 
    	if (name.equals("Aged Brie")) {
    		item = new AgedBrie(sellIn, quality);
    	} else if (name.equals("Sulfuras, Hand of Ragnaros")) {
    		item = new Sulfuras(sellIn, quality);
    	} else if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
    		item = new BackstagePass(sellIn, quality);
    	} else if (name.equals("Town Portal")) {
    		item = new TownPortal(sellIn, quality);    		
    	} else {
    		item = new Item(name, sellIn, quality);
    	}
    	GildedRose app = new GildedRose(new Item[] { item });
    	app.updateQuality();
		return app;
    }
}
