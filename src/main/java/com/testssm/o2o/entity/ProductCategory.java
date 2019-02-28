package com.testssm.o2o.entity;

import java.util.Date;

/**
 * 商品类别
 */
public class ProductCategory {
    // ID
    private Long ProductCategoryId;
    // 名称
    private String ProductCategoryName;
    // 权重
    private Integer priority;
    // 创建时间
    private Date createTime;
    // 店铺ID
    private Shop shop;

    public Long getProductCategoryId() {
        return ProductCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        ProductCategoryId = productCategoryId;
    }

    public String getProductCategoryName() {
        return ProductCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        ProductCategoryName = productCategoryName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
