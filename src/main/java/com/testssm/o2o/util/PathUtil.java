package com.testssm.o2o.util;

import java.io.File;

public class PathUtil {
    //文件分隔符
    private static final String seperator = File.separator;
    //图片根路径
    public static String getImgBasePath(){
        //操作系统名称
        String os = System.getProperties().getProperty("os.name");
        String basePath = "";
        if(os.toLowerCase().startsWith("win")){//windows
            basePath = "D:/uploadimg/image/";
        }else {
            basePath = "/home/uploadimg/image/";
        }
        //根据不同的系统进行统一替换
        basePath = basePath.replace("/",seperator);
        return basePath;
    }

    public static String getShopImagePath(long shopId){
        String imagePath = "/item/shop/" + shopId + "/";
        return imagePath.replace("/",seperator);
    }
}
