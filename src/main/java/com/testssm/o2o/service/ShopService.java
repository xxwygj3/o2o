package com.testssm.o2o.service;

import com.testssm.o2o.dto.ShopExcecution;
import com.testssm.o2o.entity.Shop;

import java.io.File;

public interface ShopService {
    ShopExcecution addShop(Shop shop, File shopImg);
}
