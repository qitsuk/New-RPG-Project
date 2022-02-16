package dk.qitsuk.customexceptions;

public class InvalidWeaponException extends Exception {
    public InvalidWeaponException(String errorMessage) {
        super(errorMessage);
    }
}
