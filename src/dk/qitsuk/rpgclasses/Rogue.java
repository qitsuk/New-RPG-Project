package dk.qitsuk.rpgclasses;

import dk.qitsuk.armors.Armor;
import dk.qitsuk.characters.RPGCharacter;
import dk.qitsuk.characters.Slot;
import dk.qitsuk.customexceptions.InvalidArmorException;
import dk.qitsuk.customexceptions.InvalidWeaponException;
import dk.qitsuk.weapons.Weapon;

public class Rogue extends RPGCharacter {
    public Rogue(String name) {
        super(name, RPGClasses.ROGUE);
    }
    @Override
    public void levelUp() {
        getPrimaryAttributes().increaseAll(4, 1, 1 );
        increaseLevel();
        calculateTotalDPS();
    }

    @Override
    public String equipWeapon(Weapon weapon, Slot slot) {
        try {
            if (slot != Slot.WEAPON) {
                throw new InvalidWeaponException("Can't equip a weapon to a non weapon slot. Try again.");
            }
            if (getLevel() < weapon.getLevelRequirement()) {
                throw new InvalidWeaponException("This Character is not high enough level to equip this weapon. " +
                        "Character is level " + getLevel() + " but needs to be level " + weapon.getLevelRequirement() +
                        ". No weapon equipped.");
            }
            switch (weapon.getWeaponType()) {
                case DAGGER, SWORD -> {
                    getEquipment().put(slot, weapon);
                    calculateTotalDPS();
                    return weapon.getName() + " Successfully Equipped.";
                }
                default -> throw new InvalidWeaponException("This class cannot equip " + weapon.getName() +
                        " because it is a " + weapon.getWeaponType().name() + ". No weapon equipped.");
            }
        } catch (InvalidWeaponException iwe) {
            return iwe.getMessage();
        }
    }

    @Override
    public String equipArmor(Armor armor, Slot slot) {
        try {
            if (slot == Slot.WEAPON) {
                throw new InvalidArmorException("Cannot equip armor to weapon slot. No armor equipped.");
            }
            if (getLevel() < armor.getLevelRequirement()) {
                throw new InvalidArmorException("This Character is not high enough level to equip this armor. " +
                        "Character is level " + getLevel() + " but needs to be level " + armor.getLevelRequirement() +
                        ". No armor equipped.");
            }
            switch(armor.getArmorType()) {
                case LEATHER, MAIL -> {
                    getEquipment().put(slot, armor);
                    getPrimaryAttributes().setArmorPrimary(armor.getPrimaryAttribute());
                    return armor.getName() + " Successfully Equipped.";
                }
                default -> throw new InvalidArmorException("This class cannot equip " + armor.getName() +
                        " because it is a " + armor.getArmorType().name() + " armor. No armor equipped.");
            }
        } catch (InvalidArmorException iae) {
            return iae.getMessage();
        }
    }
}
