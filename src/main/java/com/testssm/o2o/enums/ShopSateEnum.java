package com.testssm.o2o.enums;

public enum ShopSateEnum {
    CHECK(0,"审核中"),OFFLINE(-1,"非常店铺"),SUCCESS(1,"操作成功"),
    PASS(2,"通过认证"),INNER_ERROR(-1001,"内部系统错误"),
    NULL_SHOPID(-1002,"ShopId为空");
    private int state;
    private String stateInfo;
    private ShopSateEnum(int state,String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }
    /**
     * 依据传入的state返回相应的enum值
     */
    public static ShopSateEnum stateOf(int state){
        for(ShopSateEnum stateEnum:values()){
            if(stateEnum.getState() == state){
                return stateEnum;
            }
        }
        return null;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
