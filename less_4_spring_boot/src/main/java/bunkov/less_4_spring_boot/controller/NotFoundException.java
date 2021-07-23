package bunkov.less_4_spring_boot.controller;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message){
        super(message);
    }
}
