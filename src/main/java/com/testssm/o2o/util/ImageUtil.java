package com.testssm.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();

    /**
     * 对图片进行压缩并加水印
     * @param thumbnailInputStream
     * @param fileName
     * @param targetAddr
     * @return
     */
    public static String generateThumbnail(InputStream thumbnailInputStream,String fileName,String targetAddr){
        String realFileName = getRandomFileName();//生成随机文件名
        String extension = getFileExtension(fileName);//获取输入文件流的扩展名
        makeDirPath(targetAddr);//创建目标路径所涉及到的目录
        String relativeAddr = targetAddr + realFileName + extension;//获取图片相对路径（目标路径+随机名+扩展名）
        logger.debug("current relativeAddr is:" + relativeAddr);
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);//新生成文件路径(根路径+targetAddr + realFileName + extension)
        logger.debug("current complete addr is:" + PathUtil.getImgBasePath() + relativeAddr);
        logger.debug("basePath:"+basePath);
        //创建缩略图并加水映
        try {
            Thumbnails.of(thumbnailInputStream)
                    .size(200,200)
                    .watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath+"/watermark.jpg")),0.25f)
                    .outputQuality(0.8f)
                    .toFile(dest);
        }catch (IOException e){
            logger.error(e.toString());
            e.printStackTrace();
        }
        return relativeAddr;
    }

    /**
     * 将CommonsMultipartFile转换成File,
     * 因为springmvc会自动把前端图片封装成CommonsMultipartFile,
     * 上面压缩图片加水映方法可以直接传入CommonsMultipartFile，但是不方便测试，
     * 所以上面方法是用的File,然后用这个方法把前端传入的CommonsMultipartFile转为File
     * @param cFile
     * @return
     */
    public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile){
        File newFile = new File(cFile.getOriginalFilename());
        try {
            cFile.transferTo(newFile);
        } catch (IllegalStateException e) {
            logger.error(e.toString());
            e.printStackTrace();
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return newFile;
    }

    /**
     * 创建目标路径所涉及到的目录,即D://uploadimg//image//xxx.jpg
     * 那么 uploadimg image 自动递归创建
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if(!dirPath.exists()){
            dirPath.mkdirs();
        }
    }

    /**
     * 获取输入文件流的扩展名
     * @param fileName
     * @return
     */
    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成随机文件名，当前年月日小时分钟秒钟+五位随机数
     * @return
     */
    public static String getRandomFileName(){
        // 获取随机的五位数
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr + rannum;
    }

    /**
     * storePath是文件的路径还是目录的路径，
     * 如果storePath是文件路径则删除文件，
     * 如果storePath是目录路径则删除该目录下的所有文件
     * @param storePath
     */
    public static void deleteFileOrPath(String storePath){
        File fileOrPath = new File(PathUtil.getImgBasePath()+storePath);
        if(fileOrPath.exists()){
            if(fileOrPath.isDirectory()){
                File files[] = fileOrPath.listFiles();
                for(int i = 0;i < files.length;i++){
                    files[i].delete();
                }
            }
            fileOrPath.delete();
        }
    }


    public static void main(String[] args) throws IOException {
        //D:/test_ssm/o2o/target/classes/
        String basePath = Thread.currentThread().getContextClassLoader()
                .getResource("").getPath();
        Thumbnails.of(new File("D://uploadimg//image//xiaohuangren.jpg"))//原图文件的路径
                .size(200,200)//图片大小
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath+"/watermark.jpg")),0.25f)//添加水印图片
                .outputQuality(0.8f)//片的质量
                .toFile("D://uploadimg//image//xiaohuangrennew.jpg");//压缩后文件的路径
    }
}
