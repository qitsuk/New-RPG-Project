package dk.qitsuk.characters;

public abstract class RPGCharacter {
    private String name;
    protected PrimaryAttributes primaryAttributes;
    private int level;
    private RPGClasses characterClass;

    public RPGCharacter(String name, RPGClasses characterClass) {
        this.name = name;
        this.level = 1;
        this.characterClass = characterClass;
        // Apparently, new and improved java switch statement doesn't need break keyword.
        switch(characterClass) {
            case MAGE -> {
                primaryAttributes = new PrimaryAttributes(8, 1, 1);
            }
            case RANGER -> {
                primaryAttributes = new PrimaryAttributes(7, 1, 1);
            }
            case ROGUE -> {
                primaryAttributes = new PrimaryAttributes(6, 2, 1);
            }
            case WARRIOR -> {
                primaryAttributes = new PrimaryAttributes(5, 2, 1);
            }
        }
    }

    public abstract void levelUp();

    @Override
    public String toString() {
        StringBuilder outputString = new StringBuilder();
        outputString.append(name + " is a level " + getLevel() + " " + characterClass +
                ". These are their current stats: ");
        switch(characterClass) {
            case MAGE -> {
                outputString.append("\nIntelligence: " + primaryAttributes.getPrimary() + "\nDexterity: " +
                        primaryAttributes.getSecondary()  + "\nStrength: " + primaryAttributes.getTertiary());
            }
            case RANGER -> {
                outputString.append("\nDexterity: " + primaryAttributes.getPrimary() + "\nIntelligence: " +
                        primaryAttributes.getSecondary()  + "\nStrength: " + primaryAttributes.getTertiary());
            }
            case ROGUE -> {
                outputString.append("\nDexterity: " + primaryAttributes.getPrimary() + "\nStrength: " +
                        primaryAttributes.getSecondary()  + "\nIntelligence: " + primaryAttributes.getTertiary());
            }
            case WARRIOR -> {
                outputString.append("\nStrength: " + primaryAttributes.getPrimary() + "\nDexterity: " +
                        primaryAttributes.getSecondary()  + "\nIntelligence: " + primaryAttributes.getTertiary());
            }
        }
        return outputString.toString();
    }

    public int getLevel() {
        return level;
    }
    public void increaseLevel() {
        level++;
    }

    public String getName() {
        return name;
    }
}
