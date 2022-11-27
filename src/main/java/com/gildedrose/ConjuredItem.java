package com.gildedrose;

public class ConjuredItem extends StandardItem {

    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public void updateQualityAndSellIn() {
        getItem().sellIn = updateSellIn(getItem().sellIn, UPDATERATE);
        getItem().quality = updateQuality(getItem().quality, getItem().sellIn, UPDATERATE * 2);
    }

}
