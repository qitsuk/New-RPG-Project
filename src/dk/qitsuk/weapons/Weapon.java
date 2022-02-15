package dk.qitsuk.weapons;

import dk.qitsuk.Equipable;

public class Weapon implements Equipable {
    private final WeaponType weaponType;
    private final String name;
    private final String quality;
    private final int levelRequirement;
    private final double dps;

    public Weapon(String name, String quality, WeaponType weaponType, int levelRequirement, double damage, double attackSpeed) {
        this.name = name;
        this.weaponType = weaponType;
        this.levelRequirement = levelRequirement;
        dps = Math.round((damage * attackSpeed) * 100.0) / 100.0;
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

    @Override
    public double getDPS() {
        return dps;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }
}
