package dk.qitsuk.weapons;

import dk.qitsuk.Equipable;
import dk.qitsuk.characters.Slot;

public class Weapon implements Equipable {
    private final WeaponType weaponType;
    private final String name;
    private final String quality;
    private final int levelRequirement;
    private final double dps;
    private final Slot slot = Slot.WEAPON;

    public Weapon(String name, String quality, WeaponType weaponType, int levelRequirement, double damage, double attackSpeed) {
        this.name = name;
        this.weaponType = weaponType;
        this.levelRequirement = levelRequirement;
        dps = damage * attackSpeed;
        this.quality = quality;
    }
    @Override
    public String toString() {
        return name + " is a " + quality + " " + weaponType + " with a base DPS of: " + dps;
    }

    @Override
    public int getLevelRequirement() {
        return levelRequirement;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getDPS() {
        return dps;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public Slot getSlot() {
        return slot;
    }
}
