package dk.qitsuk;

import dk.qitsuk.characters.Mage;
import dk.qitsuk.characters.RPGCharacter;
import dk.qitsuk.customexceptions.InvalidWeaponException;
import dk.qitsuk.weapons.Weapon;
import dk.qitsuk.weapons.WeaponType;


public class Main {

    public static void main(String[] args) {
	// write your code here
        Weapon bow = new Weapon("Test Bow", WeaponType.BOW, 1, 2.3, 1.5);
        Weapon wand = new Weapon("Puny Bone Wand", WeaponType.WAND, 1, 2.1, 1.3);
        Weapon staff = new Weapon("Superior Staff of Spellcasting", WeaponType.STAFF, 12, 58.4, 8.5);
//        System.out.println(bow.toString("common"));
//        System.out.println(wand.toString("common"));
//        System.out.println(staff.toString("superior"));

        RPGCharacter mage = new Mage("Gwen");
        System.out.println(mage);
        while (mage.getLevel() < 12) {
            mage.levelUp();
        }

        System.out.println(mage);

    }
}
