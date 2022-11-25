package com.gildedrose;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LegendaryItem implements ItemInterface {

    private Item item;

    @Override
    public void updateQualityAndSellIn() {
        //do noting, values remain the same
    }

}
