package com.vishal.User.Exception;

public class ResourceNotFoundException extends RuntimeException{

    ResourceNotFoundException(){
        super("No resource found");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
