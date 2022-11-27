package com.gildedrose;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StandardItem implements ItemInterface {

    private Item item;

    @Override
    public void updateQualityAndSellIn() {
        //The goblin should have added Getters and Setters in Item
        this.item.sellIn = updateSellIn(this.item.sellIn, UPDATERATE);
        this.item.quality = updateQuality(this.item.quality, this.item.sellIn, UPDATERATE);
    }

    protected int updateSellIn(int sellIn, int rate) {
        return sellIn - rate;
    }

    protected int updateQuality(int quality, int sellIn, int rate) {
        int newQuality;
        if (sellIn < 0) {
            newQuality = quality - (rate * 2);
        } else {
            newQuality = quality - rate;
        }
        if (newQuality < 0) {
            newQuality = 0;
        }
        return newQuality;
    }

}
