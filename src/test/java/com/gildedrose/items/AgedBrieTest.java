package com.gildedrose.items;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AgedBrieTest {
    @Test
    public void testBrieQualityIncreasesByOneEveryDay() {
    	AgedBrie item = new AgedBrie(10, 10);
    	item.update();
        assertEquals(11, item.quality.value());
    }
    
    @Test
    public void testBrieSellInDecreasesByOneEveryDay() {
    	AgedBrie item = new AgedBrie(10, 10);
    	item.update();
        assertEquals(9, item.sellIn);    	
    }

    @Test
    public void testAgedBrieQualityIncreasesByTwoAfterExpiry() {
    	AgedBrie item = new AgedBrie(0, 10);
    	item.update();
        assertEquals(12, item.quality.value());
    }    
}
