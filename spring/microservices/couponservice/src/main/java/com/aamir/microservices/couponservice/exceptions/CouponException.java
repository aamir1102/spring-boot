package com.aamir.microservices.couponservice.exceptions;

public class CouponException extends RuntimeException{
    public CouponException(String message){
        super(message);
    }
}
