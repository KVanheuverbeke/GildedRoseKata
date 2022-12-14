package com.gildedrose;

public class BackstageItem extends SpecialItem {

    public BackstageItem(Item item) {
        super(item);
    }

    @Override
    protected int updateQuality(int quality, int sellIn, int rate) {
        int newQuality;
        if (sellIn >= 10) {
            newQuality = quality + rate;
        } else if (sellIn >= 5) {
            newQuality = quality + (rate * 2);
        } else if (sellIn >= 0) {
            newQuality = quality + (rate * 3);
        } else {
            newQuality = 0;
        }
        if (newQuality > MAXQUAL) {
            newQuality = MAXQUAL;
        }
        return newQuality;
    }

}
