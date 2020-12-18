package de.morrisbr.cookieclicker.cookie;

public class Upgrades {

    public static int[] upgrates = new int[] {0, 1};



    public static int[] getUpgrates() {
        return upgrates;
    }

    public static void setMultiplikator(int id, int price) {
        Upgrades.upgrates[id] = price;
    }

}
