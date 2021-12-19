package com.gauravssnl.arithmetica.service;

import java.util.Arrays;

import com.gauravssnl.arithmetica.dto.ResultDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AritmeticOperationServiceImpl implements AritmeticOperationService {

    private final Logger log = LoggerFactory.getLogger(AritmeticOperationServiceImpl.class);

    @Override
    public Boolean isGreaterThanGivenNum(Number number, Number givenNumber) {
        return number.doubleValue() > givenNumber.doubleValue();
    }

    @Override
    public ResultDTO square(Number number) {

        if (number.intValue() == number.doubleValue()) {
            return new ResultDTO(String.valueOf(Math.round(Math.pow(number.doubleValue(), 2))));
        }
        return new ResultDTO(String.valueOf(Math.pow(number.doubleValue(), 2)));
    }

    @Override
    public ResultDTO squareRoot(Number number) {
        return new ResultDTO(String.valueOf(Math.sqrt(number.doubleValue())));
    }

    @Override
    public ResultDTO sumOfDigits(Number number) {
        String numString = String.valueOf(number);
        char[] numChars = numString.toCharArray();
        log.debug("Inside sumOfDigits service. numChars: {}", Arrays.toString(numChars));
        Long sum = 0L;
        for (char ch : numChars) {
            if (Character.isDigit(ch)) {
                log.debug("Inside sumOfDigits service. Long value: {}", Long.valueOf(ch));
                // Substract the ASCII value of '0' from the ASCII value of char ch.
                sum += Long.valueOf(ch) - Long.valueOf('0');
            }
        }
        return new ResultDTO(String.valueOf(sum));
    }

}
