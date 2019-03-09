package com.testssm.o2o.service.impl;

import com.sun.imageio.plugins.common.ImageUtil;
import com.sun.javafx.scene.shape.PathUtils;
import com.testssm.o2o.dao.ShopDao;
import com.testssm.o2o.dto.ShopExcecution;
import com.testssm.o2o.entity.Shop;
import com.testssm.o2o.enums.ShopSateEnum;
import com.testssm.o2o.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Date;

public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;
    @Override
    @Transactional
    public ShopExcecution addShop(Shop shop, File shopImg) {
        //空值判断
        if(shop == null){
            return new ShopExcecution(ShopSateEnum.NULL_SHOPID);
        }
        try {
            //给店铺信息赋初始值
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            //添加店铺信息
            int effectedNum = shopDao.insertShop(shop);
            if(effectedNum <= 0){
                throw new RuntimeException("店铺创建失败");
            }else{
                if(shopImg != null){
                    //存储图片
                    try {
                        addShopImg(shop,shopImg);
                    }catch (Exception e){
                        throw new RuntimeException("addShopImg error:"+e.getMessage());
                    }
                    //更新店铺的图片地址
                    effectedNum = shopDao.updateShop(shop);
                    if(effectedNum <= 0){
                        throw new RuntimeException("更新图片地址失败");
                    }
                }
            }
        }catch (Exception e){
            throw new RuntimeException("addShop error:"+e.getMessage());
        }
        return new ShopExcecution(ShopSateEnum.CHECK,shop);
    }

    private void addShopImg(Shop shop,File shopImg){
        //获取shop图片目录的相对值路径
        /*String dest = PathUtils.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImg,dest);
        shop.setShopImg(shopImgAddr);*/
    }
}
