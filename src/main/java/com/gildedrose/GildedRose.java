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
        for (Item item : items) {
            if (!item.getName().equals(AGED_PRIE)
                    && !item.getName().equals(BACKSTAGE)) {
                if (item.getQuality() > QUALITY_LOWER_LIMIT && !item.getName().equals(SULFURAS)) {
                    item.setQuality(item.getQuality() - 1);
                }
            } else if (item.getQuality() < QUALITY_UPPER_LIMIT) {
                item.setQuality(item.getQuality() + 1);
            }

            if (item.getName().equals(BACKSTAGE) && item.getQuality() < QUALITY_UPPER_LIMIT) {
                if (item.getSellIn() < SELL_IN_THRESHOLDS[2]) {
                    item.setQuality(item.getQuality() + 1);
                }

                if (item.getSellIn() < SELL_IN_THRESHOLDS[1] && item.getQuality() < QUALITY_UPPER_LIMIT) {
                    item.setQuality(item.getQuality() + 1);
                }
            }

            updateQualityBasedOnSellIn(item);
        }
    }

    private void updateQualityBasedOnSellIn(Item item) {
        if (!item.getName().equals(SULFURAS)) {
            item.setSellIn(item.getSellIn() - 1);
        }

        if (item.getSellIn() < SELL_IN_THRESHOLDS[0]) {
            switch (item.getName()) {
                case AGED_PRIE:
                    if (item.getQuality() < QUALITY_UPPER_LIMIT) {
                        item.setQuality(item.getQuality() + 1);
                    }
                    break;
                case BACKSTAGE:
                    item.setQuality(0);
                    break;
                case SULFURAS:
                    break;
                default:
                    if (item.getQuality() > QUALITY_LOWER_LIMIT) {
                        item.setQuality(item.getQuality() - 1);
                    }
            }
        }
    }
}
