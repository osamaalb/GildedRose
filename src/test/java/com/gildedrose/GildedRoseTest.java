package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {
  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", -1, 2);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.toString(), is("foo, -2, 0"));
  }
  
  @Test
  @DisplayName("Test that the quality is correct")
  void testQuality() {
    Item[] input = new Item[] {
        new Item("Not Mentioned in the code", -1, 2),
        new Item("Not Mentioned in the code", -1, 0),
        new Item("Not Mentioned in the code", -1, 5),
        new Item("Not Mentioned in the code", 1, 5),
        new Item("Aged Brie", 3, 2),
        new Item("Aged Brie", -2, 2),
        new Item("Aged Brie", -2, 55),
        new Item("Aged Brie", -2, 49),
        new Item("Backstage passes to a TAFKAL80ETC concert", 2, 2),
        new Item("Backstage passes to a TAFKAL80ETC concert", 9, 2),
        new Item("Backstage passes to a TAFKAL80ETC concert", 11, 50),
        new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10),
        new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10),
        new Item("Backstage passes to a TAFKAL80ETC concert", 2, 49),
        new Item("Backstage passes to a TAFKAL80ETC concert", 9, 49),
        new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48),
        new Item("Backstage passes to a TAFKAL80ETC concert", 5, 47),
        new Item("Backstage passes to a TAFKAL80ETC concert", 12, 2),
        new Item("Backstage passes to a TAFKAL80ETC concert", -5, 2),
        new Item("Sulfuras, Hand of Ragnaros", 5, 60),
        new Item("Sulfuras, Hand of Ragnaros", -1, 5),
        new Item("Sulfuras, Hand of Ragnaros", 0, 5),
        new Item("Sulfuras, Hand of Ragnaros", 5, -1)
    };
    
    Item[] expectedOutput = new Item[] {
        new Item("Not Mentioned in the code", -2, 0),
        new Item("Not Mentioned in the code", -2, 0),
        new Item("Not Mentioned in the code", -2, 3),
        new Item("Not Mentioned in the code", 0, 4),
        new Item("Aged Brie", 2, 3),
        new Item("Aged Brie", -3, 4),
        new Item("Aged Brie", -3, 55),
        new Item("Aged Brie", -3, 50),
        new Item("Backstage passes to a TAFKAL80ETC concert", 1, 5),
        new Item("Backstage passes to a TAFKAL80ETC concert", 8, 4),
        new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50),
        new Item("Backstage passes to a TAFKAL80ETC concert", 10, 11),
        new Item("Backstage passes to a TAFKAL80ETC concert", 5, 12),
        new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50),
        new Item("Backstage passes to a TAFKAL80ETC concert", 8, 50),
        new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50),
        new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50),
        new Item("Backstage passes to a TAFKAL80ETC concert", 11, 3),
        new Item("Backstage passes to a TAFKAL80ETC concert", -6, 0),
        new Item("Sulfuras, Hand of Ragnaros", 5, 60),
        new Item("Sulfuras, Hand of Ragnaros", -1, 5),
        new Item("Sulfuras, Hand of Ragnaros", 0, 5),
        new Item("Sulfuras, Hand of Ragnaros", 5, -1)
    };
        
    GildedRose app = new GildedRose(input);
    app.updateQuality();
    for (int i = 0; i < input.length; i++) {
        assertThat(input[i].toString(), is(expectedOutput[i].toString()));
    }
  }
}
