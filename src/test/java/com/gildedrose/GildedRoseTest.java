package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.Item;

public class GildedRoseTest {

    @Test
    public void testItemSellInDecreasesByOneEveryDay() {
    	GildedRose app = loadItems("mouse", 10, 10);
        assertEquals(9, app.items[0].sellIn);
    }
    
    @Test
    public void testHandSellInNeverDecreases() {
    	GildedRose app = loadItems("Sulfuras, Hand of Ragnaros", 10, 10);
        assertEquals(10, app.items[0].sellIn);    	
    }
	
    @Test
    public void testHandQualityNeverDecreases() {
    	GildedRose app = loadItems("Sulfuras, Hand of Ragnaros", 10, 10);
        assertEquals(10, app.items[0].quality);    	
    }   
	
    @Test
    public void testRegularItemQualityDecreasesByOneEveryDay() {
    	GildedRose app = loadItems("mouse", 10, 10);
        assertEquals(9, app.items[0].quality);
    }
    
    @Test
    public void testBrieQualityIncreasesByOneEveryDay() {
    	GildedRose app = loadItems("Aged Brie", 10, 10);
        assertEquals(11, app.items[0].quality);    	
    }
    
    @Test
    public void testConcertQualityIncreasesByOneEveryDay() {
    	GildedRose app = loadItems("Backstage passes to a TAFKAL80ETC concert", 20, 10);
        assertEquals(11, app.items[0].quality);
    }
    
    @Test
    public void testConcertQualityIncreasesByTwoInLastTenDays() {
    	GildedRose app = loadItems("Backstage passes to a TAFKAL80ETC concert", 10, 10);
        assertEquals(12, app.items[0].quality);
    }
    
    @Test
    public void testConcertQualityIncreasesByThreeInLastFiveDays() {
    	GildedRose app = loadItems("Backstage passes to a TAFKAL80ETC concert", 5, 10);
        assertEquals(13, app.items[0].quality);    	
    }
    
    @Test
    public void testQualityDoesntGoBelowZero() {
    	GildedRose app = loadItems("mouse", 10, 0);
        assertEquals(0, app.items[0].quality);    	
    }
    
    @Test
    public void testQualityMaxesAtFifty() {
    	GildedRose app = loadItems("Aged Brie", 10, 50);
        assertEquals(50, app.items[0].quality);
    }
    
    @Test
    public void testRegularItemDecreasesQualityByTwoAfterExpiry() {
    	GildedRose app = loadItems("mouse", 0, 10);
        assertEquals(8, app.items[0].quality);    	
    }
    
    @Test
    public void testConcertQualityIsZeroAfterExpiry() {
    	GildedRose app = loadItems("Backstage passes to a TAFKAL80ETC concert", 0, 10);
        assertEquals(0, app.items[0].quality);
    }
  
    @Test
    public void testHandQualityDoesntChangeAfterExpiry() {
    	GildedRose app = loadItems("Sulfuras, Hand of Ragnaros", -1, 10);
        assertEquals(10, app.items[0].quality);
    }
    
    @Test
    public void testAgedBrieQualityIncreasesByTwoAfterExpiry() {
    	GildedRose app = loadItems("Aged Brie", 0, 10);
        assertEquals(12, app.items[0].quality);
    }
    
    @Test
    public void testQualityIsBoundedBetweenZeroAndFifty() {
    	String[] items = new String[] { 
    			"mouse", "Aged Brie", "Sulfuras, Hand of Ragnaros",
    			"Backstage passes to a TAFKAL80ETC concert"
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
    	Item[] items; 
    	if (name.equals("Aged Brie")) {
    		items = new Item[] { new AgedBrie(name, sellIn, quality) };
    	} else {
    		items = new Item[] { new Item(name, sellIn, quality) };
    	}
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
		return app;
    }
}
