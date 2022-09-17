package com.gildedrose;

class GildedRose {
    Item[] items;
    private static final String AGED_PRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final int QUALITY_LOWER_LIMIT = 0;
    private static final int QUALITY_UPPER_LIMIT = 50;
    private static final int[] SELL_IN_THRESHOLDS = new int[] {0, 6, 11};

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return this.items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals(AGED_PRIE)
                    && !items[i].name.equals(BACKSTAGE)) {
                if (items[i].quality > QUALITY_LOWER_LIMIT) {
                    if (!items[i].name.equals(SULFURAS)) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < QUALITY_UPPER_LIMIT) {
                    items[i].quality = items[i].quality + 1;
                    if (items[i].name.equals(BACKSTAGE)) {
                        if (items[i].sellIn < SELL_IN_THRESHOLDS[2]) {
                            if (items[i].quality < QUALITY_UPPER_LIMIT) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < SELL_IN_THRESHOLDS[1]) {
                            if (items[i].quality < QUALITY_UPPER_LIMIT) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals(SULFURAS)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < SELL_IN_THRESHOLDS[0]) {
                if (!items[i].name.equals(AGED_PRIE)) {
                    if (!items[i].name.equals(BACKSTAGE)) {
                        if (items[i].quality > QUALITY_LOWER_LIMIT) {
                            if (!items[i].name.equals(SULFURAS)) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < QUALITY_UPPER_LIMIT) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
