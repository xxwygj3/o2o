package com.testssm.o2o.dao;

import com.testssm.o2o.entity.ShopCategory;

import java.util.List;

public interface ShopCategoryDao {
    /**
     * 商铺类别列表
     * @return
     */
    List<ShopCategory> getShopCategoryList();
}
