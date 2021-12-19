package com.gauravssnl.arithmetica.service;

import com.gauravssnl.arithmetica.dto.ResultDTO;

public interface AritmeticOperationService {
    public ResultDTO square(Number number);

    public ResultDTO squareRoot(Number number);

    public ResultDTO sumOfDigits(Number number);

    public Boolean isGreaterThanGivenNum(Number number, Number givenNumber);
}
