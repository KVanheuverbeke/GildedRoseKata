package com.gildedrose;

public class ItemFactory {

    private ItemFactory() {
    }

    public static StandardItem getStandardItem(String name) {

        switch (Items.valueOf(name.substring(0, 6))) {
            case AGEDCH:
                return new AgedCheeseItem();

            case  BACKST:
                return new BackstageItem();

            case LEGEND:
                return new LegendaryItem();

            default:
                return new StandardItem();
        }

    }
}
