package dk.qitsuk.characters;

public class PrimaryAttributes {
    private final int basePrimary;
    private int totalPrimary;
    private int secondary;
    private int tertiary;
    private final double baseDPS;

    public PrimaryAttributes(int primary, int secondary, int tertiary) {
        this.basePrimary = this.totalPrimary = primary;
        this.secondary = secondary;
        this.tertiary = tertiary;
        baseDPS = 1 + (double)primary / 100.00;
    }


    public void increaseAll(int primary, int secondary, int tertiary) {
       totalPrimary += primary;
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

    public int getTotalPrimary() {
        return totalPrimary;
    }


    // endregion
}
