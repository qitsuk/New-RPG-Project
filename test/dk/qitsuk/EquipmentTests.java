package dk.qitsuk;

import dk.qitsuk.armors.Armor;
import dk.qitsuk.armors.ArmorType;
import dk.qitsuk.characters.RPGCharacter;
import dk.qitsuk.characters.Slot;
import dk.qitsuk.customexceptions.InvalidArmorException;
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
    Armor chestPlate;

    @BeforeEach
    void setup() {
        warrior = new Warrior("Conan");
        axe = new Weapon("Battle-Axe", "exceptional", WeaponType.AXE, 3, 31, 1.2);
        sword = new Weapon("Zwei Hander", "common", WeaponType.SWORD, 1, 7, 1.7);
        chestPlate = new Armor(ArmorType.PLATE, "Sturdy Chestplate", "common", 1, Slot.BODY, 1);

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
    @Test
    void WarriorDPSValidWeaponAndArmor_LevelOne_ShouldPass() {
        try {
            warrior.equipWeapon(sword, Slot.WEAPON);
        } catch (InvalidWeaponException ignored) {}
        try {
            warrior.equipArmor(chestPlate, Slot.BODY);
        } catch (InvalidArmorException ignored) {}

        double expected = (7 * 1.7) * warrior.getUnarmedDPS();
        double actual = warrior.getTotalDPS();
        assertEquals(expected, actual);
    }
    @Test
    void WarriorStatIncrease_EquipArmor_ShouldPass() {
        try {
            warrior.equipArmor(chestPlate, Slot.BODY);
        } catch(InvalidArmorException ignored) {}
        int expected = warrior.getPrimaryAttributes().getBasePrimary() + 1;
        int actual = warrior.getPrimaryAttributes().getTotalPrimary();
        assertEquals(expected, actual);
    }
}
