package com.example.Employee.exception;

import com.example.Employee.utils.Message;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class EmployeeException {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DuplicateKeyException.class)
    public Map<String,String> handlerException(DuplicateKeyException exception){
        Map<String,String> object = new HashMap<>();
        object.put("code","500");
        object.put("message",exception.getMessage());
        object.put("status", Message.CODE);
        return object;
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handlerException(MethodArgumentNotValidException exception){
        Map<String,String> object = new HashMap<>();
        object.put("code","500");
        object.put("message",exception.getMessage());
        object.put("status", Message.CODE);
        return object;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public Map<String,String> handlerException(Exception exception){
        Map<String,String> object = new HashMap<>();
        object.put("code","400");
        object.put("message",exception.getMessage());
        object.put("status", Message.ERROR);
        return object;
    }
}
