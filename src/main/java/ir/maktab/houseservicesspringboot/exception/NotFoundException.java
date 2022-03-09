package ir.maktab.houseservicesspringboot.exception;

/**
 * @author Mahsa Alikhani m-58
 */
public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }
}
