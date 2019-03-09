package com.testssm.o2o.dto;

import com.testssm.o2o.entity.Shop;
import com.testssm.o2o.enums.ShopSateEnum;
import java.util.List;

public class ShopExcecution {
    //结果状态
    private int state;
    //状态标识
    private String stateInfo;
    //店铺数量
    private int count;
    //操作的shop（增删改店铺的时候的时候使用）
    private Shop shop;
    //shop列表（查询店铺列表的时候使用）
    private List<Shop> shopList;
    public ShopExcecution(){

    }
    // 店铺操作失效的时候使用的构造器
    public ShopExcecution(ShopSateEnum stateEnum){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }
    // 店铺操作成功的时候使用的构造器
    public ShopExcecution(ShopSateEnum stateEnum,Shop shop){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shop = shop;
    }
    // 店铺操作成功的时候使用的构造器
    public ShopExcecution(ShopSateEnum stateEnum,List<Shop> shopList){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shopList = shopList;
    }
}
