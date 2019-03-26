package com.testssm.o2o.service;

import com.testssm.o2o.dto.ImageHolder;
import com.testssm.o2o.dto.ShopExecution;
import com.testssm.o2o.entity.Shop;
import com.testssm.o2o.exceptions.ShopOperationException;

import java.io.InputStream;

public interface ShopService {
    /**
     * 根据shopCondition分页返回相应店铺列表
     * @param shopCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public ShopExecution getShopList(Shop shopCondition,int pageIndex,int pageSize);
    /**
     * 通过店铺Id获取店铺信息
     * @param shopId
     * @return
     */
    Shop getByShopId(long shopId);

    /**
     * 更换店铺信息，包括对图片的处理
     * @param shop
     * @param thumbnail
     * @return
     * @throws ShopOperationException
     */
    ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;

    /**
     * 注册店铺信息，包括图片处理
     * @param shop
     * @param thumbnail
     * @return
     * @throws ShopOperationException
     */
    ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;

}
