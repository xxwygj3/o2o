package com.testssm.o2o.dao;

import com.testssm.o2o.BaseTest;
import com.testssm.o2o.entity.Product;
import com.testssm.o2o.entity.ProductCategory;
import com.testssm.o2o.entity.ProductImg;
import com.testssm.o2o.entity.Shop;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest extends BaseTest {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductImgDao productImgDao;

    @Test
    public void testQueryProductList() throws Exception {
        Product product = new Product();
        //分页查询，预期返回三条结果
        List<Product> productList = productDao.queryProductList(product, 0, 3);
        assertEquals(3, productList.size());
        //查询名称为测试的商品总数
        int count = productDao.queryProductCount(product);
        assertEquals(4, count);
        //使用商品名称模糊查询，预期返回两条结果
        product.setProductName("测试");
        productList = productDao.queryProductList(product, 0, 3);
        assertEquals(2, productList.size());
        count = productDao.queryProductCount(product);
        assertEquals(2, count);
    }

    @Test
    public void testQueryProductByProductId() throws Exception{
        long productId = 1;
        //初始化两个商品详情图实例作为productId为1的商品下的详情图片
        //批量插入到商品详情图表中
        ProductImg productImg1 = new ProductImg();
        productImg1.setImgAddr("图片1");
        productImg1.setImgDesc("测试图片1");
        productImg1.setPriority(1);
        productImg1.setCreateTime(new Date());
        productImg1.setProductId(productId);
        ProductImg productImg2 = new ProductImg();
        productImg2.setImgAddr("图片2");
        productImg2.setImgDesc("测试图片2");
        productImg2.setPriority(1);
        productImg2.setCreateTime(new Date());
        productImg2.setProductId(productId);
        List<ProductImg> productImgList = new ArrayList<ProductImg>();
        productImgList.add(productImg1);
        productImgList.add(productImg2);
        int effectedNum = productImgDao.batchInsertProductImg(productImgList);
        assertEquals(2, effectedNum);
        //查询productId为1的商品信息并校验返回的详情图实例列表size是否为2
        Product product = productDao.queryProductById(productId);
        assertEquals(2, product.getProductImgList().size());
        //删除新增的这两个商品详情图实例
        effectedNum = productImgDao.deleteProductImgByProductId(productId);
        assertEquals(2, effectedNum);
    }

    @Test
    public void testUpdateProduct() throws Exception{
        Product product = new Product();
        ProductCategory pc = new ProductCategory();
        Shop shop = new Shop();
        shop.setShopId(1L);
        pc.setProductCategoryId(2L);
        product.setProductId(1L);
        product.setShop(shop);
        product.setProductName("第一个产品");
        product.setProductCategory(pc);
        //修改productId为1的商品的名称
        //以及商品类别并检验影响的行数是否为1
        int effectedNum = productDao.updateProduct(product);
        assertEquals(1, effectedNum);
    }

    @Test
    public void testUpdateProductCategoryToNull(){
        int effectedNum = productDao.updateProductCategoryToNull(2L);
        assertEquals(1,effectedNum);
    }
}
