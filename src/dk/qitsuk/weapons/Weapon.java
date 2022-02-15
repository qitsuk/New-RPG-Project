package dk.qitsuk.weapons;

public class Weapon {
    private final WeaponType weaponType;
    private final String name;
    private final int levelRequirement;
//    private final double damage;
//    private final double attackSpeed;
    private final double dps;

    public Weapon(String name, WeaponType weaponType, int levelRequirement, double damage, double attackSpeed) {
        this.name = name;
        this.weaponType = weaponType;
        this.levelRequirement = levelRequirement;
//        this.damage = damage;
//        this.attackSpeed = attackSpeed;
        dps = Math.round((damage * attackSpeed) * 100.0) / 100.0;
    }

    public String toString(String quality) {
        return name + " is a " + quality + " " + weaponType + " with a base DPS of: " + dps;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    public String getName() {
        return name;
    }

    public double getDps() {
        return dps;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }
}
