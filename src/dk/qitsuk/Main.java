package dk.qitsuk;

import dk.qitsuk.armors.Armor;
import dk.qitsuk.armors.ArmorType;
import dk.qitsuk.characters.Slot;
import dk.qitsuk.customexceptions.InvalidArmorException;
import dk.qitsuk.customexceptions.InvalidWeaponException;
import dk.qitsuk.rpgclasses.Mage;
import dk.qitsuk.characters.RPGCharacter;
import dk.qitsuk.rpgclasses.Ranger;
import dk.qitsuk.rpgclasses.Rogue;
import dk.qitsuk.rpgclasses.Warrior;
import dk.qitsuk.weapons.Weapon;
import dk.qitsuk.weapons.WeaponType;


public class Main {

    public static void main(String[] args) {
        RPGCharacter warrior = new Warrior("Conan");
        Weapon testSword = new Weapon("Test Sword", "common", WeaponType.SWORD, 1, 7, 1.7);
        Armor chestPlate = new Armor(ArmorType.PLATE, "Sturdy Chestplate", "common", 1, Slot.BODY, 1);
/*
        System.out.println(mage);
        System.out.println(ranger);
        System.out.println(rogue);
        System.out.println(warrior);*/
        System.out.println(warrior);
        try {
            System.out.println(warrior.equipWeapon(testSword, Slot.WEAPON));
        } catch (InvalidWeaponException ignored) {}
        System.out.println(warrior);
        try {
            System.out.println(warrior.equipArmor(chestPlate, Slot.BODY));
        } catch (InvalidArmorException ignored) {}
        System.out.println(warrior);

    }
}
