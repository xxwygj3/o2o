package com.testssm.o2o.service;

import com.testssm.o2o.dto.ImageHolder;
import com.testssm.o2o.dto.ProductExecution;
import com.testssm.o2o.entity.Product;
import com.testssm.o2o.exceptions.ProductOperationException;

import java.util.List;

public interface ProductService {
    /**
     * 添加商品信息以及图片处理
     * @param product
     * @param thumbnail
     * @param productImgs
     * @return
     * @throws ProductOperationException
     */
    ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgs) throws ProductOperationException;
}
