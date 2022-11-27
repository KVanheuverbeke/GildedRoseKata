package com.gildedrose;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LegendaryItem implements ItemInterface {

    private Item item;

    @Override
    public void updateQualityAndSellIn() {
        //do nothing, values remain the same
        item.quality = LEGENDARYMAXQUALITY;
    }

}
