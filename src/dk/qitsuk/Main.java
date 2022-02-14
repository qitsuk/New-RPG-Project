package dk.qitsuk;

import dk.qitsuk.characters.Mage;
import dk.qitsuk.characters.RPGCharacter;
import dk.qitsuk.characters.RPGClasses;

public class Main {

    public static void main(String[] args) {
	// write your code here
        RPGCharacter mage = new Mage("Gwen");
        System.out.println(mage);
        mage.levelUp();
        System.out.println(mage.getName() + " has leveled up! Woohoo, happy days!");
        System.out.println("-------------------");
        System.out.println(mage);

    }
}
