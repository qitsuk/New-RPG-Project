package dk.qitsuk.armors;

import dk.qitsuk.Equipable;
import dk.qitsuk.characters.Slot;

public class Armor implements Equipable {

    private final ArmorType armorType;
    private final String name;
    private final String quality;
    private final int levelRequirement;
    private final Slot slot;
    private final int primaryAttribute;

    public Armor(ArmorType armorType, String name, String quality, int levelRequirement, Slot slot, int primary) {
        this.armorType = armorType;
        this.name = name;
        this.quality = quality;
        this.levelRequirement = levelRequirement;
        this.slot = slot;
        this.primaryAttribute = primary;
    }


    @Override
    public int getLevelRequirement() {
        return levelRequirement;
    }

    public double getDPS() {
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name + " is a " + quality + " " + armorType +  " with a primary attribute increase of "
                + primaryAttribute;
    }
}
