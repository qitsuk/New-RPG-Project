package dk.qitsuk.characters;

public class PrimaryAttributes {
    private int intelligence;
    private int dexterity;
    private int strength;

    public PrimaryAttributes(int primary, int secondary, int tertiary) {

    }


    // region Getters and Setters
    public int getIntelligence() {
        return intelligence;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getStrength() {
        return strength;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
    // endregion
}
