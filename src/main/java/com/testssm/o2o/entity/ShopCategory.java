package com.testssm.o2o.entity;

import java.util.Date;

/**
 * 店铺类别
 */
public class ShopCategory {
    // ID
    private Long ShopCategoryId;
    // 名称
    private String ShopCategoryName;
    // 描述
    private String ShopCategoryDesc;
    // 图片
    private String ShopCategoryImg;
    // 权重
    private Integer priority;
    // 创建时间
    private Date createTime;
    // 修改时间
    private Date lastEditTime;
    // 上级ID
    private ShopCategory parent;

    public Long getShopCategoryId() {
        return ShopCategoryId;
    }

    public void setShopCategoryId(Long shopCategoryId) {
        ShopCategoryId = shopCategoryId;
    }

    public String getShopCategoryName() {
        return ShopCategoryName;
    }

    public void setShopCategoryName(String shopCategoryName) {
        ShopCategoryName = shopCategoryName;
    }

    public String getShopCategoryDesc() {
        return ShopCategoryDesc;
    }

    public void setShopCategoryDesc(String shopCategoryDesc) {
        ShopCategoryDesc = shopCategoryDesc;
    }

    public String getShopCategoryImg() {
        return ShopCategoryImg;
    }

    public void setShopCategoryImg(String shopCategoryImg) {
        ShopCategoryImg = shopCategoryImg;
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

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public ShopCategory getParent() {
        return parent;
    }

    public void setParent(ShopCategory parent) {
        this.parent = parent;
    }
}
