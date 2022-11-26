package com.gildedrose;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class StandardItem implements ItemInterface {

    private Item item;

    @Override
    public void updateQualityAndSellIn() {
        setSellIn(getSellIn() - 1);

        if (getSellIn() < 0) {
            setQuality(getQuality() - 2);
        } else {
            setQuality(getQuality() - 1);
        }

        if (getQuality() < 0) {
            setQuality(0);
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
