package dk.qitsuk;

import dk.qitsuk.characters.Mage;
import dk.qitsuk.characters.RPGCharacter;
import dk.qitsuk.characters.RPGClasses;
import dk.qitsuk.weapons.Weapon;
import dk.qitsuk.weapons.WeaponType;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Weapon weapon = new Weapon("Test Bow", WeaponType.BOW, 1, 2.3, 1.5);
        System.out.println(weapon);

    }
}
