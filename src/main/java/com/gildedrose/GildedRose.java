package com.gildedrose;

class GildedRose {
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
            item.updateQuality();
        }
    }
}
