package dk.qitsuk.characters;

import dk.qitsuk.Equipable;
import dk.qitsuk.armors.Armor;
import dk.qitsuk.customexceptions.InvalidArmorException;
import dk.qitsuk.customexceptions.InvalidWeaponException;
import dk.qitsuk.rpgclasses.RPGClasses;
import dk.qitsuk.weapons.Weapon;

import java.util.HashMap;

public abstract class RPGCharacter {
    // These are declared final, because they're never changed after they get set.
    private final String name;
    private final RPGClasses characterClass;
    private final HashMap<Slot, Equipable> equipment;

    private PrimaryAttributes primaryAttributes;
    private double unarmedDPS;
    private double totalDPS;
    private int level;

    // Handling the assignment of what is the primary attribute, when creating the hero/character.
    // Again, probably not the cleanest way of implementing it, as it can get quite confusing, if you
    // don't have the character sheet handy.
    public RPGCharacter(String name, RPGClasses characterClass) {
        this.name = name;
        this.level = 1;
        this.characterClass = characterClass;
        equipment = new HashMap<>();
        // Apparently, new and improved java switch statement doesn't need break keyword.
        switch (characterClass) {
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
        unarmedDPS = 1 + (double) getPrimaryAttributes().getTotalPrimary() / 100.00;
        calculateTotalDPS();
    }

    // Each RPGClass needs a way to level up, however, their methods are slighty different,
    // different, so we make it abstract and force the classes to implement the function.
    // The same goes for equipWeapon and equipArmor.
    public abstract void levelUp();

    public abstract String equipWeapon(Weapon weapon, Slot slot) throws InvalidWeaponException;

    public abstract String equipArmor(Armor armor, Slot slot) throws InvalidArmorException;

    // Small helper function, to handle level up.
    public void increaseLevel() {
        level++;
    }

    // Calculating the total DPS, taking care of currently equipped items.
    public void calculateTotalDPS() {
        if (equipment.isEmpty()) {
            if (getLevel() == 1) {
                totalDPS = getPrimaryAttributes().getBaseDPS();
            } else {
                totalDPS = unarmedDPS;
            }
        } else {
            for (Equipable equipped : equipment.values()) {
                if (equipped instanceof Armor) {
                    totalDPS += 1 + (double)getPrimaryAttributes().getTotalPrimary() / 100;
                }
                if (equipped instanceof Weapon) {
                    totalDPS = equipped.getDPS() * unarmedDPS;
                }
            }
        }
    }
    // A toString method that takes into account, what RPGClass it is called from.
    @Override
    public String toString() {
        StringBuilder outputString = new StringBuilder();
        outputString.append(name + " is a level " + getLevel() + " " + characterClass +
                ".\nThese are their current stats: ");
        switch (characterClass) {
            case MAGE -> {
                outputString.append("\nIntelligence: " + primaryAttributes.getTotalPrimary() + "\nDexterity: " +
                        primaryAttributes.getSecondary() + "\nStrength: " + primaryAttributes.getTertiary()
                        + "\nDPS: " + totalDPS);
            }
            case RANGER -> {
                outputString.append("\nDexterity: " + primaryAttributes.getTotalPrimary() + "\nIntelligence: " +
                        primaryAttributes.getSecondary() + "\nStrength: " + primaryAttributes.getTertiary()
                        + "\nDPS: " + totalDPS);
            }
            case ROGUE -> {
                outputString.append("\nDexterity: " + primaryAttributes.getTotalPrimary() + "\nStrength: " +
                        primaryAttributes.getSecondary() + "\nIntelligence: " + primaryAttributes.getTertiary()
                        + "\nDPS: " + totalDPS);
            }
            case WARRIOR -> {
                outputString.append("\nStrength: " + primaryAttributes.getTotalPrimary() + "\nDexterity: " +
                        primaryAttributes.getSecondary() + "\nIntelligence: " + primaryAttributes.getTertiary()
                        + "\nDPS: " + totalDPS);
            }
        }
        return outputString.toString();
    }


    // A few getters.
    public int getLevel() {
        return level;
    }

    public PrimaryAttributes getPrimaryAttributes() {
        return primaryAttributes;
    }

    public HashMap<Slot, Equipable> getEquipment() {
        return equipment;
    }

    public double getTotalDPS() {
        return totalDPS;
    }
    public double getUnarmedDPS() {
        return unarmedDPS;
    }
}
