package com.myProperty.Property_Manageent.Exception;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@ControllerAdvice
public class CustomExceptationHandler extends RuntimeException{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException manv){

        List<ErrorModel> errorModelList = new ArrayList<>();
        ErrorModel errorModel = null;
        List<FieldError> fieldErrorList = manv.getBindingResult().getFieldErrors();

        for(FieldError fe: fieldErrorList){
            errorModel = new ErrorModel();
            errorModel.setCode(fe.getField());
            errorModel.setMessage(fe.getDefaultMessage());
            errorModelList.add(errorModel);
        }

        return new ResponseEntity<List<ErrorModel>>(errorModelList, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> businessExceptionHandler(BusinessException bex){
        System.out.println("In BusinessException Exceptation Parent class");
        return new ResponseEntity<List<ErrorModel>>(bex.getErrors(),HttpStatus.BAD_REQUEST) ;
    }
}
