package org.asiczen;

public class RoomAlreadyBookedException extends RuntimeException{

    public RoomAlreadyBookedException(String message){
        super(message);
    }
}
