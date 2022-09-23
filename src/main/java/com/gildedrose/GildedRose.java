package com.gildedrose;

class GildedRose {
    private static final String AGED_PRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final int QUALITY_LOWER_LIMIT = 0;
    private static final int QUALITY_UPPER_LIMIT = 50;
    private static final int[] SELL_IN_THRESHOLDS = {0, 6, 11};

    private Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void setItems(Item[] items) {
        this.items = items;
    }

    Item[] getItems() {
        return this.items;
    }

    void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].getName().equals(AGED_PRIE)
                    && !items[i].getName().equals(BACKSTAGE)) {
                if (items[i].getQuality() > QUALITY_LOWER_LIMIT && !items[i].getName().equals(SULFURAS)) {
                    items[i].setQuality(items[i].getQuality() - 1);
                }
            } else if (items[i].getQuality() < QUALITY_UPPER_LIMIT) {
                items[i].setQuality(items[i].getQuality() + 1);
            }

            if (items[i].getName().equals(BACKSTAGE) && items[i].getQuality() < QUALITY_UPPER_LIMIT) {
                if (items[i].getSellIn() < SELL_IN_THRESHOLDS[2]) {
                    items[i].setQuality(items[i].getQuality() + 1);
                }

                if (items[i].getSellIn() < SELL_IN_THRESHOLDS[1] && items[i].getQuality() < QUALITY_UPPER_LIMIT) {
                    items[i].setQuality(items[i].getQuality() + 1);
                }
            }

            if (!items[i].getName().equals(SULFURAS)) {
                items[i].setSellIn(items[i].getSellIn() - 1);
            }

            if (items[i].getSellIn() < SELL_IN_THRESHOLDS[0]) {
                if (
                    !items[i].getName().equals(AGED_PRIE)
                        && !items[i].getName().equals(BACKSTAGE)
                        && items[i].getQuality() > QUALITY_LOWER_LIMIT
                        && !items[i].getName().equals(SULFURAS)
                ) {
                    items[i].setQuality(items[i].getQuality() - 1);
                }

                if (items[i].getName().equals(BACKSTAGE)) {
                    items[i].setQuality(items[i].getQuality() - items[i].getQuality());
                }

                if (items[i].getName().equals(AGED_PRIE) && items[i].getQuality() < QUALITY_UPPER_LIMIT) {
                    items[i].setQuality(items[i].getQuality() + 1);
                }
            }
        }
    }
}
