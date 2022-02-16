package dk.qitsuk;

import dk.qitsuk.characters.RPGCharacter;
import dk.qitsuk.rpgclasses.Mage;
import dk.qitsuk.rpgclasses.Ranger;
import dk.qitsuk.rpgclasses.Rogue;
import dk.qitsuk.rpgclasses.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {
    // region Testing if all chars are level one on creation
    @Test
    void mageIsLevelOne_AtCreation_ShouldPass() {
        RPGCharacter mage = new Mage("Gwen");
        int expected = 1;
        int actual = mage.getLevel();
        assertEquals(expected, actual);
    }
    @Test
    void rangerIsLevelOne_AtCreation_ShouldPass() {
        RPGCharacter ranger = new Ranger("Legolas");
        int expected = 1;
        int actual = ranger.getLevel();
        assertEquals(expected, actual);
    }
    @Test
    void rogueIsLevelOne_AtCreation_ShouldPass() {
        RPGCharacter rogue = new Rogue("Kali");
        int expected = 1;
        int actual = rogue.getLevel();
        assertEquals(expected, actual);
    }
    @Test
    void warriorIsLevelOne_AtCreation_ShouldPass() {
        RPGCharacter warrior = new Warrior("Conan");
        int expected = 1;
        int actual = warrior.getLevel();
        assertEquals(expected, actual);
    }
    // endregion

    // region Testing if all chars are level 2 after leveling

    @Test
    void mageIsLevelTwo_AfterLeveling_ShouldPass() {
        RPGCharacter mage = new Mage("Gwen");
        mage.levelUp();
        int expected = 2;
        int actual = mage.getLevel();
        assertEquals(expected, actual);
    }
    @Test
    void rangerIsLevelTwo_AfterLeveling_ShouldPass() {
        RPGCharacter ranger = new Ranger("Legolas");
        ranger.levelUp();
        int expected = 2;
        int actual = ranger.getLevel();
        assertEquals(expected, actual);
    }
    @Test
    void rogueIsLevelTwo_AfterLeveling_ShouldPass() {
        RPGCharacter rogue = new Rogue("Kali");
        rogue.levelUp();
        int expected = 2;
        int actual = rogue.getLevel();
        assertEquals(expected, actual);
    }
    @Test
    void warriorIsLevelTwo_AfterLeveling_ShouldPass() {
        RPGCharacter warrior = new Warrior("Conan");
        warrior.levelUp();
        int expected = 2;
        int actual = warrior.getLevel();
        assertEquals(expected, actual);
    }

    // endregion

    // region Testing if all chars gain the correct amount of stats when leveled

    @Test
    void mageStatIncrease_WhenLevelUp_ShouldPass() {
        RPGCharacter mage = new Mage("Gwen");
        mage.levelUp();
        int[] expected = new int[] {13, 2, 2};
        int[] actual = new int[] { mage.getPrimaryAttributes().getTotalPrimary(), mage.getPrimaryAttributes().getSecondary(), mage.getPrimaryAttributes().getTertiary() };
        assertArrayEquals(expected, actual);
    }
    @Test
    void rangerStatIncrease_WhenLevelUp_ShouldPass() {
        RPGCharacter ranger = new Ranger("Legolas");
        ranger.levelUp();
        int[] expected = new int[]{12, 2, 2};
        int[] actual = new int[] {ranger.getPrimaryAttributes().getTotalPrimary(), ranger.getPrimaryAttributes().getSecondary(), ranger.getPrimaryAttributes().getTertiary()};
        assertArrayEquals(expected, actual);
    }
    @Test
    void rogueStatIncrease_WhenLevelUp_ShouldPass() {
        RPGCharacter rogue = new Rogue("Kali");
        rogue.levelUp();
        int[] expected = new int[]{10, 3, 2};
        int[] actual = new int[] {rogue.getPrimaryAttributes().getTotalPrimary(), rogue.getPrimaryAttributes().getSecondary(), rogue.getPrimaryAttributes().getTertiary()};
        assertArrayEquals(expected, actual);
    }

    @Test
    void warriorStatIncrease_WhenLevelUp_ShouldPass() {
        RPGCharacter warrior = new Warrior("Conan");
        warrior.levelUp();
        int[] expected = new int[]{8, 4, 2};
        int[] actual = new int[] {warrior.getPrimaryAttributes().getTotalPrimary(), warrior.getPrimaryAttributes().getSecondary(), warrior.getPrimaryAttributes().getTertiary()};
        assertArrayEquals(expected, actual);
    }

    // endregion
}
