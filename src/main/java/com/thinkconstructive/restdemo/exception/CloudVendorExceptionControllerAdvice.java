package com.thinkconstructive.restdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CloudVendorExceptionControllerAdvice {

    @ExceptionHandler(value={CloudVendorNotFoundException.class})
    public ResponseEntity<Object> handleCouldVendorNotFoundException(CloudVendorNotFoundException cloudVendorNotFoundException){
        CloudVendorException cloudVendorException = new CloudVendorException(
                                                               cloudVendorNotFoundException.getMessage(),
                                                               cloudVendorNotFoundException.getCause(),
                                                               HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(cloudVendorException,HttpStatus.NOT_FOUND);

    }

//    @ExceptionHandler(value={ArithmeticException.class})
//    public ResponseEntity<Object> handleArthmeticExceptionException(ArithmeticException  exception){
//        CloudVendorException cloudVendorException = new CloudVendorException(
//                exception.getMessage(),
//                exception.getCause(),
//                HttpStatus.NOT_FOUND);
//
//        return new ResponseEntity<>(cloudVendorException,HttpStatus.NOT_FOUND);
//
//    }

}
