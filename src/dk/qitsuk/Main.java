package dk.qitsuk;

import dk.qitsuk.characters.Mage;
import dk.qitsuk.characters.RPGCharacter;
import dk.qitsuk.customexceptions.InvalidWeaponException;
import dk.qitsuk.weapons.Weapon;
import dk.qitsuk.weapons.WeaponType;


public class Main {

    public static void main(String[] args) {
	    RPGCharacter mage = new Mage("Gwen");
        Weapon staff = new Weapon("Sturdy Wand", "common", WeaponType.STAFF, 1, 2, 1.2);
    }
}
