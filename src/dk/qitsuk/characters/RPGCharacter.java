package dk.qitsuk.characters;

import dk.qitsuk.Equipable;
import dk.qitsuk.customexceptions.InvalidWeaponException;
import dk.qitsuk.weapons.Weapon;
import dk.qitsuk.weapons.WeaponType;

import java.util.HashMap;
import java.util.Map;

public abstract class RPGCharacter {
    // These are declared final, because they're never changed after they get set.
    private final String name;
    private final RPGClasses characterClass;
    private PrimaryAttributes primaryAttributes;

    private HashMap<Slot, Equipable> equipment;

    private int level;


    public RPGCharacter(String name, RPGClasses characterClass) {
        this.name = name;
        this.level = 1;
        this.characterClass = characterClass;
        equipment = new HashMap<>();
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

    // Each RPGClass needs a way to level up, however, their methods are slighty different,
    // different, so we make it abstract and force the classes to implement the function.
    public abstract void levelUp();

    public abstract String equipWeapon(Weapon weapon) throws InvalidWeaponException;

    public void increaseLevel() {
        level++;
    }

    public void calculateTotalDPS() {
        if (equipment.isEmpty()) {

        }
    }



    // A toString method that takes into account, what RPGClass it is called from.
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

    public String getName() {
        return name;
    }

    public PrimaryAttributes getPrimaryAttributes() {
        return primaryAttributes;
    }

    public HashMap<Slot, Equipable> getEquipment() {
        return equipment;
    }
}
