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
  @DisplayName("Test name not in code sellIn less than 0 quality greater than 0")
  void testNameNotInCodeSellInLessThanZeroQualGreaterThanZero() {
    Item[] input = new Item[] {
        new Item("Not Mentioned in the code", -1, 2),
        new Item("Not Mentioned in the code", -1, 5)
    };
    
    Item[] expectedOutput = new Item[] {
        new Item("Not Mentioned in the code", -2, 0),
        new Item("Not Mentioned in the code", -2, 3)
    };
        
    GildedRose app = new GildedRose(input);
    app.updateQuality();
    for (int i = 0; i < input.length; i++) {
        assertThat(input[i].toString(), is(expectedOutput[i].toString()));
    }
  }
  
  @Test
  @DisplayName("Test name not in code sellIn less than 0 quality equals 0")
  void testNameNotInCodeSellInLessThanZeroQualEqualsZero() {
    Item input = new Item("Not Mentioned in the code", -1, 0);
    
    Item expectedOutput = new Item("Not Mentioned in the code", -2, 0);
        
    GildedRose app = new GildedRose(new Item[] {input});
    app.updateQuality();
    assertThat(input.toString(), is(expectedOutput.toString()));
  }
  
  @Test
  @DisplayName("Test name not in code sellIn greater than 0")
  void testNameNotInCodeSellInGreaterThanZero() {
    Item input = new Item("Not Mentioned in the code", 1, 5);
    
    Item expectedOutput = new Item("Not Mentioned in the code", 0, 4);
        
    GildedRose app = new GildedRose(new Item[] {input});
    app.updateQuality();
    assertThat(input.toString(), is(expectedOutput.toString()));
  }
  
  @Test
  @DisplayName("Test Aged Brie SellIn greater than 0")
  void testAgedBrieSellInGreaterThanZero() {
    Item input = new Item("Aged Brie", 3, 2);
    
    Item expectedOutput = new Item("Aged Brie", 2, 3);
        
    GildedRose app = new GildedRose(new Item[] {input});
    app.updateQuality();
    assertThat(input.toString(), is(expectedOutput.toString()));
  }
  
  @Test
  @DisplayName("Test Aged Brie SellIn less than 0 quality less than 50")
  void testAgedBrieSellInLessThanZeroQualLessThan50() {
    Item input = new Item("Aged Brie", -2, 2);
    
    Item expectedOutput = new Item("Aged Brie", -3, 4);
        
    GildedRose app = new GildedRose(new Item[] {input});
    app.updateQuality();
    assertThat(input.toString(), is(expectedOutput.toString()));
  }
  
  @Test
  @DisplayName("Test Aged Brie SellIn less than 0 quality greater than 50")
  void testAgedBrieSellInLessThanZeroQualGreaterThan50() {
    Item input = new Item("Aged Brie", -2, 55);
    
    Item expectedOutput = new Item("Aged Brie", -3, 55);
        
    GildedRose app = new GildedRose(new Item[] {input});
    app.updateQuality();
    assertThat(input.toString(), is(expectedOutput.toString()));
  }
  
  @Test
  @DisplayName("Test Aged Brie SellIn less than 0 quality 49")
  void testAgedBrieSellInLessThanZeroQual49() {
    Item input = new Item("Aged Brie", -2, 49);
    
    Item expectedOutput = new Item("Aged Brie", -3, 50);
        
    GildedRose app = new GildedRose(new Item[] {input});
    app.updateQuality();
    assertThat(input.toString(), is(expectedOutput.toString()));
  }
  
  @Test
  @DisplayName("Test Backstage SellIn less than 6 quality less than 50")
  void testBackstageSellInLessThan6QualLessThan50() {
    Item input = new Item("Backstage passes to a TAFKAL80ETC concert", 2, 2);
    
    Item expectedOutput = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 5);
        
    GildedRose app = new GildedRose(new Item[] {input});
    app.updateQuality();
    assertThat(input.toString(), is(expectedOutput.toString()));
  }
  
  @Test
  @DisplayName("Test Backstage SellIn less than 11 quality less than 50")
  void testBackstageSellInLessThan11QualLessThan50() {
    Item input = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 2);
    
    Item expectedOutput = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 4);
        
    GildedRose app = new GildedRose(new Item[] {input});
    app.updateQuality();
    assertThat(input.toString(), is(expectedOutput.toString()));
  }
  
  @Test
  @DisplayName("Test Backstage SellIn 11 quality 50")
  void testBackstageSellIn11Qual50() {
    Item input = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 50);
    
    Item expectedOutput = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50);
        
    GildedRose app = new GildedRose(new Item[] {input});
    app.updateQuality();
    assertThat(input.toString(), is(expectedOutput.toString()));
  }
  
  @Test
  @DisplayName("Test Backstage SellIn 11 quality less than 50")
  void testBackstageSellIn11QualLessThan50() {
    Item input = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10);
    
    Item expectedOutput = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 11);
        
    GildedRose app = new GildedRose(new Item[] {input});
    app.updateQuality();
    assertThat(input.toString(), is(expectedOutput.toString()));
  }
  
  @Test
  @DisplayName("Test Backstage SellIn 6 quality less than 50")
  void testBackstageSellIn6QualLessThan50() {
    Item input = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10);
    
    Item expectedOutput = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 12);
        
    GildedRose app = new GildedRose(new Item[] {input});
    app.updateQuality();
    assertThat(input.toString(), is(expectedOutput.toString()));
  }
  
  @Test
  @DisplayName("Test Backstage SellIn Less Than 6 quality 49")
  void testBackstageSellInLessThan6Qual49() {
    Item input = new Item("Backstage passes to a TAFKAL80ETC concert", 2, 49);
    
    Item expectedOutput = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50);
        
    GildedRose app = new GildedRose(new Item[] {input});
    app.updateQuality();
    assertThat(input.toString(), is(expectedOutput.toString()));
  }
  
  @Test
  @DisplayName("Test Backstage SellIn Less Than 11 quality 49")
  void testBackstageSellInLessThan11Qual49() {
    Item input = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 49);
    
    Item expectedOutput = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 50);
        
    GildedRose app = new GildedRose(new Item[] {input});
    app.updateQuality();
    assertThat(input.toString(), is(expectedOutput.toString()));
  }
  
  @Test
  @DisplayName("Test Backstage SellIn Less Than 6 quality 48")
  void testBackstageSellInLessThan6Qual48() {
    Item input = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48);
    
    Item expectedOutput = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50);
        
    GildedRose app = new GildedRose(new Item[] {input});
    app.updateQuality();
    assertThat(input.toString(), is(expectedOutput.toString()));
  }
  
  @Test
  @DisplayName("Test Backstage SellIn Less Than 6 quality 47")
  void testBackstageSellInLessThan6Qual47() {
    Item input = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 47);
    
    Item expectedOutput = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50);
        
    GildedRose app = new GildedRose(new Item[] {input});
    app.updateQuality();
    assertThat(input.toString(), is(expectedOutput.toString()));
  }
  
  @Test
  @DisplayName("Test Backstage SellIn greater than 11 quality less than 50")
  void testBackstageSellInGreaterThan11QualLessThan50() {
    Item input = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 2);
    
    Item expectedOutput = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 3);
        
    GildedRose app = new GildedRose(new Item[] {input});
    app.updateQuality();
    assertThat(input.toString(), is(expectedOutput.toString()));
  }
  
  @Test
  @DisplayName("Test Backstage SellIn less than 0 quality less than 50")
  void testBackstageSellInLessThan0QualLessThan50() {
    Item input = new Item("Backstage passes to a TAFKAL80ETC concert", -5, 2);
    
    Item expectedOutput = new Item("Backstage passes to a TAFKAL80ETC concert", -6, 0);
        
    GildedRose app = new GildedRose(new Item[] {input});
    app.updateQuality();
    assertThat(input.toString(), is(expectedOutput.toString()));
  }
  
  @Test
  @DisplayName("Test Sulfuras SellIn greater than 0 quality greater than 50")
  void testSulfurasSellInGreaterThan0QualGreaterThan50() {
    Item input = new Item("Sulfuras, Hand of Ragnaros", 5, 60);
    
    Item expectedOutput = new Item("Sulfuras, Hand of Ragnaros", 5, 60);
        
    GildedRose app = new GildedRose(new Item[] {input});
    app.updateQuality();
    assertThat(input.toString(), is(expectedOutput.toString()));
  }
  
  @Test
  @DisplayName("Test Sulfuras SellIn less than 0 quality less than 50")
  void testSulfurasSellInLessThan0QualLessThan50() {
    Item input = new Item("Sulfuras, Hand of Ragnaros", -1, 5);
    
    Item expectedOutput = new Item("Sulfuras, Hand of Ragnaros", -1, 5);
        
    GildedRose app = new GildedRose(new Item[] {input});
    app.updateQuality();
    assertThat(input.toString(), is(expectedOutput.toString()));
  }
  
  @Test
  @DisplayName("Test Sulfuras SellIn 0 quality less than 50")
  void testSulfurasSellIn0QualLessThan50() {
    Item input = new Item("Sulfuras, Hand of Ragnaros", 0, 5);
    
    Item expectedOutput = new Item("Sulfuras, Hand of Ragnaros", 0, 5);
        
    GildedRose app = new GildedRose(new Item[] {input});
    app.updateQuality();
    assertThat(input.toString(), is(expectedOutput.toString()));
  }
  
  @Test
  @DisplayName("Test Sulfuras SellIn greater than 0 quality less than 0")
  void testSulfurasSellInGreaterThan0QualLessThan0() {
    Item input = new Item("Sulfuras, Hand of Ragnaros", 5, -1);
    
    Item expectedOutput = new Item("Sulfuras, Hand of Ragnaros", 5, -1);
        
    GildedRose app = new GildedRose(new Item[] {input});
    app.updateQuality();
    assertThat(input.toString(), is(expectedOutput.toString()));
  }
}
