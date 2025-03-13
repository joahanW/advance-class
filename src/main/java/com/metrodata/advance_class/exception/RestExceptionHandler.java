package com.metrodata.advance_class.exception;

import com.metrodata.advance_class.dto.response.APIResponse;
import com.metrodata.advance_class.dto.response.ErrorResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private final View error;

    public RestExceptionHandler(View error) {
        this.error = error;
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex,
                                                               WebRequest webRequest){
        return new ResponseEntity<ErrorResponse>(ErrorResponse.builder()
                .apiPath(webRequest.getDescription(false))
                .errorCode(ex.getStatus())
                .errorMessage(ex.getMessage())
                .errorTime(Instant.now())
                .build(), HttpStatus.valueOf(ex.getStatus())
        );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex){

        List<HashMap<String,String>> err = ex.getConstraintViolations()
                .stream().map(error -> {
                    HashMap<String, String> violation = new HashMap<>();
                    violation.put(error.getPropertyPath().toString(), error.getMessage());
                    return violation;
                }).toList();
        return ResponseEntity.badRequest().body(new APIResponse<>(err));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        List<HashMap<String,String>> validationError = errors.stream().map(err -> {
           HashMap<String, String> violation = new HashMap<>();
           violation.put(
                   ((FieldError) err).getField(),
                   err.getDefaultMessage()
           );
           return violation;
        }).toList();
        return ResponseEntity.badRequest().body(validationError);
    }
}
