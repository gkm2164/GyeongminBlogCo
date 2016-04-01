package co.gyeongmin.controller.web.exception;

/**
 * Created by USER on 2016-03-29.
 */
public class LackOfPermissionException extends Exception {
    public LackOfPermissionException(String s) {
        super(s);
    }
}
