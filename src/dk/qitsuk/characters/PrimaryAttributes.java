package dk.qitsuk.characters;

public class PrimaryAttributes {
    private int basePrimary;
    private int secondary;
    private int tertiary;
    private final double baseDPS;

    public PrimaryAttributes(int primary, int secondary, int tertiary) {
        this.basePrimary = primary;
        this.secondary = secondary;
        this.tertiary = tertiary;
        baseDPS = 1 + (double)primary / 100;
    }

//    public void increasePrimary(int amount) {
//        primary += amount;
//    }
//    public void increaseSecondary(int amount) {
//        secondary += amount;
//    }
//    public void increaseTertiary(int amount) {
//        tertiary += amount;
//    }

    public void increaseAll(int primary, int secondary, int tertiary) {
        this.basePrimary += primary;
        this.secondary += secondary;
        this.tertiary += tertiary;
    }

    // region Getters and Setters

    public int getPrimary() {
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
    // endregion
}
