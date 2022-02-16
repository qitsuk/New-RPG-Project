package dk.qitsuk;

import dk.qitsuk.rpgclasses.Mage;
import dk.qitsuk.characters.RPGCharacter;
import dk.qitsuk.rpgclasses.Ranger;
import dk.qitsuk.rpgclasses.Rogue;
import dk.qitsuk.rpgclasses.Warrior;


public class Main {

    public static void main(String[] args) {
        RPGCharacter mage = new Mage("Gwen");
        RPGCharacter ranger = new Ranger("Legolas");
        RPGCharacter rogue = new Rogue("Kali");
        RPGCharacter warrior = new Warrior("Conan");

        System.out.println(mage);
        System.out.println(ranger);
        System.out.println(rogue);
        System.out.println(warrior);

    }
}
