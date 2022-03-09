package ir.maktab.houseservicesspringboot.exception;

/**
 * @author Mahsa Alikhani m-58
 */
public class NotEnoughCreditException extends RuntimeException{
    public NotEnoughCreditException(String message) {
        super(message);
    }
}
