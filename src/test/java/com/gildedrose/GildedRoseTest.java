package com.gildedrose;

import org.junit.Test;
import org.mockito.Mockito;

import com.gildedrose.items.Item;

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
}
