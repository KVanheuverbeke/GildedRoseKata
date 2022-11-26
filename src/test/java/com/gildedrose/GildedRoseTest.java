package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void toStringTest() {
        Item item = new Item("foo", 0, 0);
        assertEquals("foo, 0, 0", item.toString());
    }

    @Test
    void standardItemSellInDecrease() {
        GildedRose app = newGildedRose("+5 Dexterity Vest", 10, 20);
        app.updateQuality();
        assertEquals(9, getSellIn(app));
        app.updateQuality();
        assertEquals(8, getSellIn(app));
    }

    @Test
    void standardItemQualityDegrade() {
        GildedRose app = newGildedRose("+5 Dexterity Vest", 10, 20);
        app.updateQuality();
        assertEquals(19, getQuality(app));
    }

    @Test
    void standardItemQualityDegradesFaster() {
        GildedRose app = newGildedRose("+5 Dexterity Vest", 10, 20);
        for (int i = 1; i <= 12; i++) {
            app.updateQuality();
        }
        //Once the sell by date has passed, Quality degrades twice as fast
        assertEquals(6, getQuality(app));
    }

    @Test
    void standardItemQualityNeverNegative() {
        GildedRose app = newGildedRose("+5 Dexterity Vest", 10, 20);
        for (int i = 1; i <= 30; i++) {
            app.updateQuality();
        }
        //The Quality of an item is never negative
        assertEquals(0, getQuality(app));
    }

    @Test
    void brieItemSellInDecrease() {
        GildedRose app = newGildedRose("Aged Brie", 2, 0);
        app.updateQuality();
        assertEquals(1, getSellIn(app));
        app.updateQuality();
        assertEquals(0, getSellIn(app));
        app.updateQuality();
        assertEquals(-1, getSellIn(app));
    }

    @Test
    void brieItemQualityIncrease() {
        GildedRose app = newGildedRose("Aged Brie", 2, 0);
        app.updateQuality();
        //"Aged Brie" actually increases in Quality the older it gets
        assertEquals(1, getQuality(app));
        app.updateQuality();
        assertEquals(2, getQuality(app));
        app.updateQuality();
        assertEquals(4, getQuality(app));
    }

    @Test
    void brieItemQualityNotMoreThan50() {
        GildedRose app = newGildedRose("Aged Brie", 2, 0);
        for (int i = 1; i <= 100; i++) {
            app.updateQuality();
        }
        //The Quality of an item is never more than 50
        assertEquals(50, getQuality(app));
    }

    @Test
    void legendaryItemStaysSame() {
        GildedRose app = newGildedRose("Sulfuras, Hand of Ragnaros", 0, 80);
        app.updateQuality();
        //"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
        assertEquals(0, getSellIn(app));
        assertEquals(80, getQuality(app));
        app.updateQuality();
        assertEquals(0, getSellIn(app));
        assertEquals(80, getQuality(app));
    }

    @Test
    void ticketItemSellInDecrease() {
        GildedRose app = newGildedRose("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        app.updateQuality();
        assertEquals(14, getSellIn(app));
        app.updateQuality();
        assertEquals(13, getSellIn(app));
    }

    @Test
    void ticketItemQualityIncrease() {
        GildedRose app = newGildedRose("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        app.updateQuality();
        //"Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
        assertEquals(21, getQuality(app));
    }

    @Test
    void ticketItemQualityIncreasesFaster() {
        GildedRose app = newGildedRose("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        app.updateQuality();
        //Quality increases by 2 when there are 10 days or less
        assertEquals(22, getQuality(app));
        for (int i = 1; i <= 5; i++) {
            app.updateQuality();
        }
        //and by 3 when there are 5 days or less
        assertEquals(33, getQuality(app));
    }

    @Test
    void ticketItemQualityNeverMoreThan50() {
        GildedRose app = newGildedRose("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        app.updateQuality();
        assertEquals(50, getQuality(app));
    }

    @Test
    void ticketItemQualityAfterConcert() {
        GildedRose app = newGildedRose("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        for (int i = 1; i <= 30; i++) {
            app.updateQuality();
        }
        //Quality drops to 0 after the concert
        assertEquals(0, getQuality(app));
    }

    //TODO
    /*
    @Test
    void conjuredItemSellInDecrease() {
        GildedRose app = makeGildedRose("Conjured Mana Cake", 3, 6);
        app.updateQuality();
        assertEquals(2, getSellIn(app));
        app.updateQuality();
        assertEquals(1, getSellIn(app));
    }

    @Test
    void conjuredItemQualityDegrade() {
        GildedRose app = makeGildedRose("Conjured Mana Cake", 3, 6);
        app.updateQuality();
        assertEquals(4, getQuality(app));
    }
     */

    private GildedRose newGildedRose(String itemName, int itemSellIn, int itemQuality) {
        Item[] items = new Item[]{new Item(itemName, itemSellIn, itemQuality)};
        return new GildedRose(items);
    }

    private int getSellIn(GildedRose app) {
        return app.items[0].sellIn;
    }

    private int getQuality(GildedRose app) {
        return app.items[0].quality;
    }
}
