package com.gildedrose.items;

import static org.junit.Assert.*;

import org.junit.Test;

public class TownPortalTest {
	@Test
	public void testTownPortalQualityDecreasesByTwoEveryDay() {
		TownPortal item = new TownPortal(10, 10);
		item.update();
		assertEquals(8, item.quality);
	}

	@Test
	public void testExpiredTownPortalQualityDecreasesByFourEveryDay() {
		TownPortal item = new TownPortal(0, 10);
		item.update();
		assertEquals(6, item.quality);
	}
	
	@Test
	public void testSellInDecreasesByOneEachDay() {
		TownPortal item = new TownPortal(10, 10);
		item.update();
		assertEquals(9, item.sellIn);		
	}
}
