package dk.qitsuk.characters;

import dk.qitsuk.customexceptions.InvalidWeaponException;
import dk.qitsuk.weapons.Weapon;

public class Mage extends RPGCharacter {
    public Mage(String name) {
        super(name, RPGClasses.MAGE);
    }

    public void levelUp() {
        getPrimaryAttributes().increaseAll(5, 1, 1);
        increaseLevel();
    }
    public String equipWeapon(Weapon weapon) {
        try {
            if (getLevel() < weapon.getLevelRequirement()) {
                throw new InvalidWeaponException("This Character is not high enough level to equip this weapon. " +
                        "Character is level " + getLevel() + " but needs to be level " + weapon.getLevelRequirement() +
                        ". No weapon equipped.");
            } else {
                switch (weapon.getWeaponType()) {
                    case STAFF, WAND -> {
                        getEquipment().put(Slot.WEAPON, weapon);
                        return  weapon.getName() + " Successfully Equipped.";
                    }
                    default -> {
                        throw new InvalidWeaponException("This class cannot equip " + weapon.getName() +
                                " because it is a " + weapon.getWeaponType().name() + ". No weapon equipped.");
                    }
                }
            }
        } catch (InvalidWeaponException iwe) {
            return iwe.getMessage();
        }
    }
}
