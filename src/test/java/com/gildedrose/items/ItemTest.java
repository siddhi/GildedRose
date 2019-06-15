package com.gildedrose.items;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemTest {
    @Test
    public void testItemSellInDecreasesByOneEveryDay() {
    	Item item = new Item("mouse", 10, 10);
    	item.update();
        assertEquals(9, item.sellIn);
    }
    
    @Test
    public void testRegularItemQualityDecreasesByOneEveryDay() {
    	Item item = new Item("mouse", 10, 10);
    	item.update();
        assertEquals(9, item.quality);
    }

    @Test
    public void testQualityDoesntGoBelowZero() {
    	Item item = new Item("mouse", 10, 0);
    	item.decrementQuality();
        assertEquals(0, item.quality);
    }

    @Test
    public void testQualityMaxesAtFifty() {
    	Item item = new Item("mouse", 10, 50);
    	item.incrementQuality();
        assertEquals(50, item.quality);
    }
    
    @Test
    public void testRegularItemDecreasesQualityByTwoAfterExpiry() {
    	Item item = new Item("mouse", 0, 10);
    	item.update();
        assertEquals(8, item.quality);    	
    }
}
