package com.gauravssnl.arithmetica.controller;

import com.gauravssnl.arithmetica.dto.ResultDTO;
import com.gauravssnl.arithmetica.service.AritmeticOperationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/arithmetic")
public class AritmeticOperationController {
    @Autowired
    private AritmeticOperationService aritmeticOperationService;

    private final Logger log = LoggerFactory.getLogger(AritmeticOperationController.class);

    @GetMapping("/square/{number}")
    public ResponseEntity<ResultDTO> square(@PathVariable Number number) {
        log.debug("Inside square API. Input num: ", number);
        return new ResponseEntity<>(aritmeticOperationService.square(number), HttpStatus.OK);
    }

    @GetMapping("/square-root/{number}")
    public ResponseEntity<ResultDTO> squareRoot(@PathVariable Number number) {
        log.debug("Inside squareRoot API. Input num: ", number);
        return new ResponseEntity<>(aritmeticOperationService.squareRoot(number), HttpStatus.OK);
    }

    @GetMapping("/digits-sum/{number}")
    public ResponseEntity<ResultDTO> sumOfDigits(@PathVariable Number number) {
        log.debug("Inside sumOfDigits API. Input num: ", number);
        return new ResponseEntity<>(aritmeticOperationService.sumOfDigits(number), HttpStatus.OK);
    }

    @GetMapping("/greater-than/{number}/{givenNumToCompareWith}")
    public ResponseEntity<Boolean> isGreaterThanGivenNum(@PathVariable Number number, Number givenNumToCompareWith) {
        log.debug("Inside isGreaterThanGivenNum API. Input num: ", number, "givenNumToCompareWith:",
                givenNumToCompareWith);
        return new ResponseEntity<>(aritmeticOperationService.isGreaterThanGivenNum(number, givenNumToCompareWith),
                HttpStatus.OK);
    }
}
