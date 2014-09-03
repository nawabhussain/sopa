package de.sopa.helper;

/**
 * @author Raphael Schilling
 */
public class LevelServiceException extends RuntimeException {
    public LevelServiceException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}