package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }


    public void setName (String name) {
        this.name = name;
    }


    public void setSellIn (int sellIn) {
        this.sellIn = sellIn;
    }


    public void setQuality (int quality) {
        this.quality = quality;
    }

    public String getName () {
        return this.name;
    }

    public int getSellIn () {
        return this.sellIn;
    }

    public int getQuality () {
        return this.quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
