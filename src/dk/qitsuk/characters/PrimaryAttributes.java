package dk.qitsuk.characters;

public class PrimaryAttributes {
    private int primary;
    private int secondary;
    private int tertiary;

    public PrimaryAttributes(int primary, int secondary, int tertiary) {
        this.primary = primary;
        this.secondary = secondary;
        this.tertiary = tertiary;
    }

    public void increasePrimary(int amount) {
        primary += amount;
    }
    public void increaseSecondary(int amount) {
        secondary += amount;
    }
    public void increaseTertiary(int amount) {
        tertiary += amount;
    }


    // region Getters and Setters

    public int getPrimary() {
        return primary;
    }

    public int getSecondary() {
        return secondary;
    }

    public int getTertiary() {
        return tertiary;
    }
    // endregion
}
