package com.testssm.o2o.dao;

import com.testssm.o2o.entity.Shop;
import org.apache.ibatis.annotations.Param;

public interface ShopDao {
    /**
     * 查询店铺信息
     * @param shopId
     * @return
     */
    Shop queryByShopId(@Param("shopId") long shopId);
    /**
     * 新增店铺
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}
