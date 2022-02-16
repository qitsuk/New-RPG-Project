package dk.qitsuk.characters;

public class PrimaryAttributes {
    // Instead of naming each attribute, intelligence, dex and str, I chose to go with primary,
    // secondary and tertiary. This is probably not the cleanest implementation, but it works.
    private final int basePrimary;
    private int totalPrimary;
    private int secondary;
    private int tertiary;
    private int armorPrimary;
    private final double baseDPS;


    public PrimaryAttributes(int primary, int secondary, int tertiary) {
        this.basePrimary = this.totalPrimary = primary;
        this.secondary = secondary;
        this.tertiary = tertiary;
        armorPrimary = 0;
        baseDPS = 1 + (double)(primary + armorPrimary)/ 100.00;
    }


    public void increaseAll(int primary, int secondary, int tertiary) {
       totalPrimary += primary;
       this.secondary += secondary;
       this.tertiary += tertiary;
    }

    // region Getters and Setters

    public int getBasePrimary() {
        return basePrimary;
    }

    public int getSecondary() {
        return secondary;
    }

    public int getTertiary() {
        return tertiary;
    }

    public double getBaseDPS() {
        return baseDPS;
    }

    public int getTotalPrimary() {
        return totalPrimary + armorPrimary;
    }

    public int getArmorPrimary() {
        return armorPrimary;
    }

    public void setArmorPrimary(int armorPrimary) {
        this.armorPrimary = armorPrimary;
    }


    // endregion
}
