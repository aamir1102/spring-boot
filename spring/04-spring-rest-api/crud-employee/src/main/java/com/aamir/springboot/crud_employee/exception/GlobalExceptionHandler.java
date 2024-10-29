package com.aamir.springboot.crud_employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeError> employeeNotFoundHandler(EmployeeException e){
        EmployeeError err = new EmployeeError(
                HttpStatus.NOT_FOUND.value(), e.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
    }
}
