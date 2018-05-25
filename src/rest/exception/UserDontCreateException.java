package rest.exception;

/**
 * Created by andriusbaltrunas on 5/25/2018.
 */
public class UserDontCreateException extends Exception {

    public UserDontCreateException(String message, Throwable cause) {
        super(message, cause);
    }
}
