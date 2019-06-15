package com.gildedrose.items;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SulfurasTest {
    @Test
    public void testHandSellInNeverDecreases() {
    	Sulfuras item = new Sulfuras(10, 10);
    	item.update();
        assertEquals(10, item.sellIn);    	
    }
	
    @Test
    public void testHandQualityNeverDecreases() {
    	Sulfuras item = new Sulfuras(10, 10);
    	item.update();
        assertEquals(10, item.quality.value());    	
    }   
	
    @Test
    public void testHandQualityDoesntChangeAfterExpiry() {
    	Sulfuras item = new Sulfuras(-1, 10);
    	item.update();
        assertEquals(10, item.quality.value());
    }
}
