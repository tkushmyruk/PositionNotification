package org.example.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ControllerUtil {
    static Map<String, String> getErrors(BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            Collector<FieldError, ?, Map<String, String>> collect = Collectors.toMap(
                    fieldError -> fieldError.getField() + "Error",
                    FieldError::getDefaultMessage
            );
            return bindingResult.getFieldErrors().stream().collect(collect);
        }
        return null;
    }
}
