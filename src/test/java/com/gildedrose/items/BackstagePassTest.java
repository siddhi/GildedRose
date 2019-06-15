package com.gildedrose.items;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BackstagePassTest {
    @Test
    public void testConcertSellInDecreasesByOneEveryDay() {
    	BackstagePass item = new BackstagePass(20, 10);
    	item.update();
        assertEquals(19, item.sellIn);
    }

    @Test
    public void testConcertQualityIncreasesByOneEveryDay() {
    	BackstagePass item = new BackstagePass(20, 10);
    	item.update();
        assertEquals(11, item.quality.value());
    }
    
    @Test
    public void testConcertQualityIncreasesByTwoInLastTenDays() {
    	BackstagePass item = new BackstagePass(10, 10);
    	item.update();
        assertEquals(12, item.quality.value());
    }
    
    @Test
    public void testConcertQualityIncreasesByThreeInLastFiveDays() {
    	BackstagePass item = new BackstagePass(5, 10);
    	item.update();
        assertEquals(13, item.quality.value());
    }
    
    @Test
    public void testConcertQualityIsZeroAfterExpiry() {
    	BackstagePass item = new BackstagePass(0, 10);
    	item.update();
        assertEquals(0, item.quality.value());
    }
}
