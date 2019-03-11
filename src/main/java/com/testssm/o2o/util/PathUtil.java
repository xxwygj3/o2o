package com.testssm.o2o.util;

public class PathUtil {
    //文件分隔符
    private static String seperator = System.getProperty("file.seperator");
    //图片根路径
    public static String getImgBasePath(){
        //操作系统名称
        String os = System.getProperty("os.name");
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
        String imagePath = "/upload/item/shop/" + shopId + "/";
        return imagePath.replace("/",seperator);
    }
}
