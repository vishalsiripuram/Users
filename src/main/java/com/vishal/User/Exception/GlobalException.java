package com.vishal.User.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vishal.User.payload.ApiResponse;

@RestControllerAdvice
public class GlobalException {
    

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFound(ResourceNotFoundException ex){

        String message = ex.getMessage();

       ApiResponse response = ApiResponse.builder().message(message).success(false).status(HttpStatus.NOT_FOUND).build();

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        
    }
}
