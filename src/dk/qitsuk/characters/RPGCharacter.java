package dk.qitsuk.characters;

public abstract class RPGCharacter {
    private String name;
    private PrimaryAttributes primaryAttributes;
    private int level;

    public RPGCharacter(String name, RPGClasses thisClass) {
        this.name = name;
        this.level = 1;
        switch(thisClass) {
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
}
