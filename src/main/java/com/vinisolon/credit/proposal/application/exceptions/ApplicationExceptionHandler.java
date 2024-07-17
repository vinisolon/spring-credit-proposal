package com.vinisolon.credit.proposal.application.exceptions;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URI;

import static com.vinisolon.credit.proposal.application.enums.MessageEnum.DEFAULT_ERROR_MESSAGE;

@ControllerAdvice
public class ApplicationExceptionHandler {

    private static final URI DEFAULT_ERROR_TYPE = URI.create("ERROR");

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ProblemDetail> handleException(HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(buildProblemDetail(HttpStatus.INTERNAL_SERVER_ERROR, DEFAULT_ERROR_MESSAGE.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(BusinessException.class)
    private ResponseEntity<ProblemDetail> handleBusinessRuleException(BusinessException e, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(buildProblemDetail(HttpStatus.UNPROCESSABLE_ENTITY, e.getLocalizedMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<ProblemDetail> handleEntityNotFoundException(EntityNotFoundException e, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(buildProblemDetail(HttpStatus.NOT_FOUND, e.getLocalizedMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ProblemDetail> handleConstraintViolationException(MethodArgumentNotValidException e, HttpServletRequest request) {
        FieldError fieldError = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .findFirst()
                .orElseThrow();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(buildProblemDetail(HttpStatus.BAD_REQUEST, fieldError.getDefaultMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    private ResponseEntity<ProblemDetail> handleDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(buildProblemDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(), request.getRequestURI()));
    }

    private ProblemDetail buildProblemDetail(HttpStatus httpStatus, String messageError, String path) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(httpStatus, messageError);
        problemDetail.setInstance(URI.create(path));
        problemDetail.setType(DEFAULT_ERROR_TYPE);
        return problemDetail;
    }

}
