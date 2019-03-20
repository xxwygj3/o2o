package com.testssm.o2o.exceptions;

public class ProductCategoryOperationException extends RuntimeException {
    private static final long serialVersionUID = 2L;
    public ProductCategoryOperationException(String msg){
        super(msg);
    }
}
