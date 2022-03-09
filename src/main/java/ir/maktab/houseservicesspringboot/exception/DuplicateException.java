package ir.maktab.houseservicesspringboot.exception;

/**
 * @author Mahsa Alikhani m-58
 */
public class DuplicateException extends RuntimeException{

    public DuplicateException(String message) {
        super(message);
    }
}
