package com.gildedrose;

public class ItemFactory {

    private ItemFactory() {
    }

    public static ItemInterface defineItemType(Item item) {
        String name = item.name;

        //Better would be adding a "type" to class Item, but the goblin doesn't allow it
        if (name.startsWith("Aged Brie")) {
            return new AgedBrieItem(item);
        }

        if (name.startsWith("Backstage passes")) {
            return new BackstageItem(item);
        }

        if (name.startsWith("Sulfuras")) {
            return new LegendaryItem(item);
        }

        return new StandardItem(item);

    }

}
