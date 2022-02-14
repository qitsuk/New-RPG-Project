package dk.qitsuk.characters;

public class Mage extends RPGCharacter {
    public Mage(String name) {
        super(name, RPGClasses.MAGE);
    }
    public void levelUp() {
        primaryAttributes.increasePrimary(5);
        primaryAttributes.increaseSecondary(1);
        primaryAttributes.increaseTertiary(1);
        increaseLevel();
    }
}
