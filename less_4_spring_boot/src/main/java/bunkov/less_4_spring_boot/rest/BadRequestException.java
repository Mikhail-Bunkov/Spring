package bunkov.less_4_spring_boot.rest;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message){
        super(message);
    }
}
