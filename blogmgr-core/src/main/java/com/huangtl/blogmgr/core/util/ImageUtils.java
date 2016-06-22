package com.huangtl.blogmgr.core.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * 图片处理工具
 * @version 
 * @date 2016年4月8日
 * @author PraiseLord
 */
public final class ImageUtils {
	
	/**
	 * 取得图片压缩器
	 */
	public static ImageCompresser getCompresser(String imgPath,int width,int height){
		try {
			BufferedImage img = ImageIO.read(new File(imgPath));
			return new ImageCompresser(img, width, height,imgPath.substring(imgPath.lastIndexOf(".")+1));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * byte 转  BufferedImage
	 */
	public static BufferedImage byteToImage(byte[] src) throws IOException{
		InputStream inputStream = new ByteArrayInputStream(src);
		return ImageIO.read(inputStream);
	}
	
	/**
	 * BufferedImage 转 byte
	 */
	public static byte[] imageToByte(BufferedImage img,String ImgType) throws IOException{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(img, ImgType, bos);
		return bos.toByteArray();
	}
	
	 /** 
     * 强制压缩/放大图片到固定的大小 
     * @param w  新宽度 
     * @param h  新高度 
     */  
    public static BufferedImage compress(BufferedImage img,int w,int h) throws IOException {  
    	int width =img.getWidth();
		int height = img.getHeight();
    	if (width / height > w / h) {  
    		h = (int) (height * w / width);  
        } else {  
       	    w = (int) (width * h / height);  
        }  
        // SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢  
        BufferedImage _image = new BufferedImage(w, h,BufferedImage.TYPE_INT_RGB );   
        _image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图  
        return _image;
    }  
    
    /**
     * 图片压缩器
     */
    public static class ImageCompresser{
    	private BufferedImage img;  
        private int width;  
        private int height;
       private String imageType;
        
		/**
		 * @param img
		 * @param width		压缩后的图片宽度
		 * @param height	压缩后的图片高度
		 */
		public ImageCompresser(BufferedImage img,int width,int height,String imageType) {
			this.width = width;
			this.height = height;
			this.img = img;
			this.imageType = imageType;
		}
		
        /**
         * 保存到指定的路径
         */
        public void saveAs(String target) throws IOException{
        	BufferedImage result = compress(img, width, height);
        	ImageIO.write(result, target.substring(target.lastIndexOf(".")+1), new File(target));
        }
        
        /**
         * 保存为byte
         */
        public byte[] saveAsByte() throws IOException{
        	BufferedImage result = compress(img, width, height);
        	return imageToByte(result,imageType);
        }
    }
    
}
