package com.huangtl.blogmgr.core.init.impl;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import com.aspose.words.License;
import com.huangtl.blogmgr.core.init.Initializable;

/**
 * aspose License 注册
 * @author PraiseLord
 * @date 2017年2月9日
 *
 */
public class AsposeLicenseInit implements Initializable {
	private final static Logger logger = LoggerFactory.getLogger(AsposeLicenseInit.class);
	
	private Resource licenseResource;

	@Override
	public void init() {
		try {
			boolean flag = getWordLicense(licenseResource.getInputStream());
			if(flag){
				logger.debug("aspose word License 注册成功");
			}
			flag = getExcelLicense(licenseResource.getInputStream());
			if(flag){
				logger.debug("aspose excel License 注册成功");
			}
		} catch (IOException e) {
			logger.error("aspose License 注册文件加载失败！",e);
		}
	}
	

	/**
     * wrod license 注册
     * 
     * @return
     */
    public  boolean getWordLicense(InputStream istream) {
        boolean result = false;
        try {
            InputStream is = licenseResource.getInputStream();
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
        	logger.error("aspose word License 注册失败",e);
        }
        return result;
    }
    
    /**
     * excel license 注册
     * 
     * @return
     */
    public  boolean getExcelLicense(InputStream istream) {
        boolean result = false;
        try {
        	 InputStream is = licenseResource.getInputStream();
            com.aspose.cells.License aposeLic = new com.aspose.cells.License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
        	logger.error("aspose excel License 注册失败",e);
        }
        return result;
    }
    
	
	public void setLicenseResource(Resource licenseResource) {
		this.licenseResource = licenseResource;
	}
}
