package com.testssm.o2o.service;

import com.testssm.o2o.BaseTest;
import com.testssm.o2o.dto.ImageHolder;
import com.testssm.o2o.dto.ShopExecution;
import com.testssm.o2o.entity.Area;
import com.testssm.o2o.entity.PersonInfo;
import com.testssm.o2o.entity.Shop;
import com.testssm.o2o.entity.ShopCategory;
import com.testssm.o2o.enums.ShopStateEnum;
import com.testssm.o2o.exceptions.ShopOperationException;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void testQueryShopListAndCount(){
        Shop shopCondition = new Shop();
        ShopCategory sc = new ShopCategory();
        sc.setShopCategoryId(1L);
        shopCondition.setShopCategory(sc);
        ShopExecution se = shopService.getShopList(shopCondition,2,2);
        System.out.println("店铺列表数为："+se.getShopList().size());
        System.out.println("店铺总数为："+se.getCount());
    }

    @Test
    @Ignore
    public void testModifyShop() throws ShopOperationException,FileNotFoundException{
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopName("修改后的店铺名称");
        File shopImg = new File("D://uploadimg//image//dabai.jpg");
        InputStream is = new FileInputStream(shopImg);
        ImageHolder imageHolder = new ImageHolder(shopImg.getName(),is);
        ShopExecution shopExecution = shopService.modifyShop(shop,imageHolder);
        System.out.println("新的图片地址为："+shopExecution.getShop().getShopImg());
    }

    @Test
    @Ignore
    public void testAddShop() throws ShopOperationException,FileNotFoundException {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺2");
        shop.setShopDesc("test2");
        shop.setShopAddr("test2");
        shop.setPhone("test2");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File shopImg = new File("D://uploadimg//image//xiaohuangren.jpg");
        InputStream is = new FileInputStream(shopImg);
        ImageHolder imageHolder = new ImageHolder(shopImg.getName(),is);
        ShopExecution se = shopService.addShop(shop,imageHolder);
        assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
    }
}
