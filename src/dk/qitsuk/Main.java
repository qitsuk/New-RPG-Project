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
        RPGCharacter mage = new Mage("Gwendolina");
        RPGCharacter ranger = new Ranger("Legolas");
        RPGCharacter rogue = new Rogue("Kali");
        RPGCharacter warrior = new Warrior("Conan");

        System.out.println(mage);
        System.out.println("________________________________________________");
        System.out.println(ranger);
        System.out.println("________________________________________________");
        System.out.println(rogue);
        System.out.println("________________________________________________");
        System.out.println(warrior);
        System.out.println("________________________________________________");


    }
}
