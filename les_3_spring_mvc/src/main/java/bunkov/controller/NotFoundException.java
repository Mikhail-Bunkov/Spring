package bunkov.controller;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message){
        super(message);
    }
}
