package com.gildedrose;

public class SpecialItem extends StandardItem {

    public SpecialItem(Item item) {
        super(item);
    }

    @Override
    protected int updateQuality(int quality, int sellIn, int rate) {
        int newQuality;
        if (sellIn < 0) {
            newQuality = quality + (rate * 2);
        } else {
            newQuality = quality + rate;
        }

        if (newQuality > MAXQUAL) {
            newQuality = MAXQUAL;
        }
        return newQuality;
    }

}
