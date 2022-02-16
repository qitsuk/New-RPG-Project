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
    Armor clothLeggings;
    Armor chainmail;

    @BeforeEach
    void setup() {
        warrior = new Warrior("Conan");
        // Failing Weapon - Level Requirement
        axe = new Weapon("Battle-Axe", "exceptional", WeaponType.AXE, 15, 16, 1.2);
        // Working Weapon
        sword = new Weapon("Zwei Hander", "common", WeaponType.SWORD, 1, 7, 1.7);
        // Working Armor
        chestPlate = new Armor(ArmorType.PLATE, "Sturdy Chestplate", "common", 1, Slot.BODY, 1);
        // Failing Armor - Level Requirement
        chainmail = new Armor(ArmorType.MAIL, "Fine Steel Chainmail", "superior", 2, Slot.BODY, 6);
        // Failing Armor - Armor Type
        clothLeggings = new Armor(ArmorType.CLOTH, "Cheap Cotton Leggings", "common", 1, Slot.LEGS, 1);

    }

    // region Warrior DPS tests
    @Test
    void warriorDPSNoWeapon_LevelOne_ShouldPass() {
        warrior.calculateTotalDPS();
        double expected = warrior.getUnarmedDPS();
        double actual = warrior.getTotalDPS();
        assertEquals(expected, actual);
    }

    @Test
    void warriorDPSValidWeapon_LevelOne_ShouldPass() {
        try {
            warrior.equipWeapon(sword, Slot.WEAPON);
            double expected = (7 * 1.7) * warrior.getUnarmedDPS();
            double actual = warrior.getTotalDPS();
            assertEquals(expected, actual);
        } catch(InvalidWeaponException ignored) {}
    }
    @Test
    void warriorDPSValidWeaponAndArmor_LevelOne_ShouldPass() {
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
    void warriorStatIncrease_EquipArmor_ShouldPass() {
        try {
            warrior.equipArmor(chestPlate, Slot.BODY);
        } catch(InvalidArmorException ignored) {}
        int expected = warrior.getPrimaryAttributes().getBasePrimary() + 1;
        int actual = warrior.getPrimaryAttributes().getTotalPrimary();
        assertEquals(expected, actual);
    }

    // endregion

    // region Exception Tests

    @Test
    void ifInvalidWeaponExceptionThrown_thenAssertionSucceeds() {
        InvalidWeaponException invalidWeaponException = assertThrows(InvalidWeaponException.class, () -> {
            warrior.equipWeapon(axe, Slot.WEAPON);
        });
        String expected = "This Character is not high enough level to equip this weapon. " +
                "Character is level " + warrior.getLevel() + " but needs to be level " + axe.getLevelRequirement() +
                ". No weapon equipped.";
        String actual = invalidWeaponException.getMessage();
        assertTrue(actual.contains(expected));
    }


    // endregion
}
