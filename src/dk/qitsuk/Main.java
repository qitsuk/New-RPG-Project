package dk.qitsuk;

import dk.qitsuk.characters.Mage;
import dk.qitsuk.characters.RPGCharacter;
import dk.qitsuk.customexceptions.InvalidWeaponException;
import dk.qitsuk.weapons.Weapon;
import dk.qitsuk.weapons.WeaponType;


public class Main {

    public static void main(String[] args) {
	    RPGCharacter mage = new Mage("Gwen");
        Weapon wand = new Weapon("Sturdy Wand", "common", WeaponType.WAND, 1, 2, 1.2);
        Weapon staff = new Weapon("Primal Ancient Staff of Hatred", "primal ancient", WeaponType.STAFF, 60, 600, 4.3);
        while (mage.getLevel() < 60) {
            mage.levelUp();
        }
        try {
            System.out.println(mage.equipWeapon(wand));
        } catch (InvalidWeaponException ignored) {}
        try {
            System.out.println(mage.equipWeapon(staff));
        } catch (InvalidWeaponException ignored) {}
        System.out.println(mage.getEquipment().size());
        System.out.println(mage);
    }
}
