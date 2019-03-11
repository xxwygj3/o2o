package com.testssm.o2o.service;

import com.testssm.o2o.dto.ShopExecution;
import com.testssm.o2o.entity.Shop;

import java.io.File;

public interface ShopService {
    ShopExecution addShop(Shop shop, File shopImg);
}
