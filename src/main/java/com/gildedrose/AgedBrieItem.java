package com.gildedrose;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AgedBrieItem extends StandardItem implements ItemInterface {

    private Item item;

    @Override
    public void updateQualityAndSellIn() {
        setSellIn(getSellIn() - 1);
        setQuality(getQuality() + 1);

        if (getQuality() > MAXQUAL) {
            setQuality(MAXQUAL);
        }
    }

    private int getSellIn() {
        return this.item.sellIn;
    }

    private void setSellIn(int sellIn) {
        this.item.sellIn = sellIn;
    }

    private int getQuality() {
        return this.item.quality;
    }

    private void setQuality(int quality) {
        this.item.quality = quality;
    }
}
