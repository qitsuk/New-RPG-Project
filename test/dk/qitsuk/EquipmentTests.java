package dk.qitsuk;

import dk.qitsuk.characters.RPGCharacter;
import dk.qitsuk.characters.Slot;
import dk.qitsuk.customexceptions.InvalidWeaponException;
import dk.qitsuk.rpgclasses.Warrior;
import dk.qitsuk.weapons.Weapon;
import dk.qitsuk.weapons.WeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EquipmentTests {
    RPGCharacter warrior;
    Weapon axe;
    Weapon sword;

    @BeforeEach
    void setup() {
        warrior = new Warrior("Conan");
        axe = new Weapon("Battle-Axe", "exceptional", WeaponType.AXE, 3, 31, 1.2);
        sword = new Weapon("Zwei Hander", "common", WeaponType.SWORD, 1, 7, 1.7);
    }
    @Test
    void WarriorDPSNoWeapon_LevelOne_ShouldPass() {
        warrior.calculateTotalDPS();
        double expected = warrior.getUnarmedDPS();
        double actual = warrior.getTotalDPS();
        assertEquals(expected, actual);
    }

    @Test
    void WarriorDPSValidWeapon_LevelOne_ShouldPass() {
        try {
            warrior.equipWeapon(sword, Slot.WEAPON);
            double expected = (7 * 1.7) * warrior.getUnarmedDPS();
            double actual = warrior.getTotalDPS();
            assertEquals(expected, actual);
        } catch(InvalidWeaponException ignored) {}
    }
}
