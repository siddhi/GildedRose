package com.gildedrose.items;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RegularItemTest {
    @Test
    public void testItemSellInDecreasesByOneEveryDay() {
    	Item item = new RegularItem("mouse", 10, 10);
    	item.update();
        assertEquals(9, item.sellIn);
    }
    
    @Test
    public void testRegularItemQualityDecreasesByOneEveryDay() {
    	Item item = new RegularItem("mouse", 10, 10);
    	item.update();
        assertEquals(9, item.quality.value());
    }

    @Test
    public void testQualityDoesntGoBelowZero() {
    	Item item = new RegularItem("mouse", 10, 0);
    	item.quality.decrement();
        assertEquals(0, item.quality.value());
    }

    @Test
    public void testQualityMaxesAtFifty() {
    	Item item = new RegularItem("mouse", 10, 50);
    	item.quality.increment();
        assertEquals(50, item.quality.value());
    }
    
    @Test
    public void testRegularItemDecreasesQualityByTwoAfterExpiry() {
    	Item item = new RegularItem("mouse", 0, 10);
    	item.update();
        assertEquals(8, item.quality.value());
    }
}
