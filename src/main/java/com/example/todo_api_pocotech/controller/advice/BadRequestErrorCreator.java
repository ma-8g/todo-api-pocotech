package com.example.todo_api_pocotech.controller.advice;

import com.example.todoapi.model.BadRequestError;
import com.example.todoapi.model.InvalidParam;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.stream.Collectors;

public class BadRequestErrorCreator {
    public static BadRequestError from(MethodArgumentNotValidException ex) {
        var invalidParamList = createInvalidParamList(ex);
        var error = new BadRequestError();
        error.setInvalidParams(invalidParamList);
        return error;
    }

    private static List<InvalidParam> createInvalidParamList(MethodArgumentNotValidException ex) {
        return ex.getFieldErrors()
                .stream()
                .map(BadRequestErrorCreator::getInvalidParam)
                .collect(Collectors.toList());
    }

    private static InvalidParam getInvalidParam(FieldError fieldError) {
        var param = new InvalidParam();
        param.setName(fieldError.getField());
        param.setReason(fieldError.getDefaultMessage());
        return param;
    }
}
