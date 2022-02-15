package dk.qitsuk.customexceptions;

public class InvalidArmorException extends Exception {
    public InvalidArmorException(String errorMessage) {
        super(errorMessage);
    }
}
