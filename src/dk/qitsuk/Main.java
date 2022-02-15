package dk.qitsuk;

import dk.qitsuk.armors.Armor;
import dk.qitsuk.armors.ArmorType;
import dk.qitsuk.characters.Mage;
import dk.qitsuk.characters.RPGCharacter;
import dk.qitsuk.characters.Slot;
import dk.qitsuk.customexceptions.InvalidArmorException;
import dk.qitsuk.customexceptions.InvalidWeaponException;
import dk.qitsuk.weapons.Weapon;
import dk.qitsuk.weapons.WeaponType;


public class Main {

    public static void main(String[] args) {
        RPGCharacter mage = new Mage("Gwen");
        Weapon wand = new Weapon("Sturdy Wand", "common", WeaponType.WAND, 1, 2, 1.2);
        Armor clothHelmet = new Armor(ArmorType.CLOTH, "Cloth Headgear", "common", 1, Slot.HEAD, 5);
        Armor clothCrown = new Armor(ArmorType.CLOTH, "Cloth Crown", "Superior", 1, Slot.HEAD, 10);

        System.out.println(mage);
        System.out.println("______________________________________________");

        try {
            System.out.println(mage.equipArmor(clothCrown, clothCrown.getSlot()));
            System.out.println("__________________________________________");
            System.out.println(mage);
            System.out.println("__________________________________________");
            System.out.println(mage.equipArmor(clothHelmet, clothHelmet.getSlot()));
            System.out.println("__________________________________________");
            System.out.println(mage);
        } catch (InvalidArmorException ignored) {
        }

        System.out.println("______________________________________________");
    }
}
