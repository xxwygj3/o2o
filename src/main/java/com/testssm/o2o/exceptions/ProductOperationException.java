package com.testssm.o2o.exceptions;

public class ProductOperationException extends RuntimeException {
    private static final long serialVersionUID = 3L;
    public ProductOperationException(String msg){
        super(msg);
    }
}
