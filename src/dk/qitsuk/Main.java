package dk.qitsuk;

import dk.qitsuk.characters.Slot;
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
        RPGCharacter mage = new Mage("Gwen");
        RPGCharacter ranger = new Ranger("Legolas");
        RPGCharacter rogue = new Rogue("Kali");
        RPGCharacter warrior = new Warrior("Conan");
        Weapon testSword = new Weapon("Test Sword", "common", WeaponType.SWORD, 1, 7, 1.7);
/*
        System.out.println(mage);
        System.out.println(ranger);
        System.out.println(rogue);
        System.out.println(warrior);*/
        System.out.println(testSword);
        System.out.println(warrior);
        try {
            System.out.println(warrior.equipWeapon(testSword, Slot.WEAPON));
        } catch (InvalidWeaponException ignored) {}

        System.out.println("This is apparently the DPS with the sword equipped: " + (7 * 1.7) * warrior.getUnarmedDPS());
        System.out.println(testSword.getDPS() * warrior.getUnarmedDPS());
    }
}
