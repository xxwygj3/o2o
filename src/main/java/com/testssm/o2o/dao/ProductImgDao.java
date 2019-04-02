package com.testssm.o2o.dao;

import com.testssm.o2o.entity.Product;
import com.testssm.o2o.entity.ProductImg;

import java.util.List;

public interface ProductImgDao {
    /**
     *
     * @param productId
     * @return
     */
    List<ProductImg> queryProductImgList(long productId);
    /**
     * 批量添加商品详情图片
     * @param productImgList
     * @return
     */
    int batchInsertProductImg(List<ProductImg> productImgList);

    /**
     * 通过productId删除唯一的商品信息
     * @param productId
     * @return
     */
    int deleteProductImgByProductId(long productId);
}
