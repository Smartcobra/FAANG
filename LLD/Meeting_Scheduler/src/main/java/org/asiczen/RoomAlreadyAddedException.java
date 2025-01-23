package org.asiczen;

public class RoomAlreadyAddedException extends RuntimeException{
    public RoomAlreadyAddedException(String message) {
        super(message);
    }
}
