package com.gildedrose;

public final class Item {
    private static final String AGED_PRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured";
    private static final int QUALITY_LOWER_LIMIT = 0;
    private static final int QUALITY_UPPER_LIMIT = 50;
    private static final int[] SELL_IN_THRESHOLDS = {0, 5, 10};

    private String name;

    private int sellIn;

    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }


    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getName() {
        return this.name;
    }

    public int getSellIn() {
        return this.sellIn;
    }

    public int getQuality() {
        return this.quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void updateQuality() {
        if (this.name.equals(SULFURAS)) {
            return;
        }

        this.sellIn -= 1;

        switch (this.name) {
            case AGED_PRIE:
                this.quality = Math.min(this.quality + 1, QUALITY_UPPER_LIMIT);

                if (this.sellIn < SELL_IN_THRESHOLDS[0]) {
                    this.quality = Math.min(this.quality + 1, QUALITY_UPPER_LIMIT);
                }
                break;
            case BACKSTAGE:
                this.quality = Math.min(this.quality + 1, QUALITY_UPPER_LIMIT);

                if (this.sellIn < SELL_IN_THRESHOLDS[0]) {
                    this.quality = 0;
                } else if (this.sellIn < SELL_IN_THRESHOLDS[1]) {
                    this.quality = Math.min(this.quality + 2, QUALITY_UPPER_LIMIT);
                } else if (this.sellIn < SELL_IN_THRESHOLDS[2]) {
                    this.quality = Math.min(this.quality + 1, QUALITY_UPPER_LIMIT);
                }
                break;
            case CONJURED:
                if (this.sellIn < SELL_IN_THRESHOLDS[0]) {
                    this.quality = Math.max(this.quality - 4, QUALITY_LOWER_LIMIT);
                } else {
                    this.quality = Math.max(this.quality - 2, QUALITY_LOWER_LIMIT);
                }
                break;
            default:
                this.quality = Math.max(this.quality - 1, QUALITY_LOWER_LIMIT);

                if (this.sellIn < SELL_IN_THRESHOLDS[0]) {
                    this.quality = Math.max(this.quality - 1, QUALITY_LOWER_LIMIT);
                }
                break;
        }
    }
}
