package com.huangtl.blogmgr.action;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * ckeditor文件上传
 * @author Canaan
 * @date 2017年6月12日
 *
 */
@Controller
@RequestMapping(value="/ckeditor")
public class CKEditorUploadAction extends BlogMgrAction {
	
	private final Logger logger = LoggerFactory.getLogger(CKEditorUploadAction.class);
	
	private String fileRoot = "E:/Data/BlogMgr/upload/ckeditor/"; //文件上传路径
	
	/**
	 * ckEditor富文本编辑器图片上传接口
	 */
	@RequestMapping(value="upload.do",method=RequestMethod.POST)
	@ResponseBody
	public void ckEditorImageUpload( @RequestParam(value = "upload",required = true) MultipartFile file,
	        @RequestParam(value = "CKEditorFuncNum",required = true) String CKEditorFuncNum,
	        HttpServletRequest request,
	        HttpServletResponse response){
		
		LocalDate localDate = new LocalDate();
		StringBuilder filePathBuilder = new StringBuilder(fileRoot);
		filePathBuilder.append(localDate.getYear()).append(localDate.getMonthOfYear()).append(localDate.getDayOfMonth()) //file path
		          .append("/").append(uuid()).append("_").append(file.getOriginalFilename()); //file name
		
	    String filePath = filePathBuilder.toString();
	    logger.debug("file upload and filePath is {}",filePath);
	    
	    File fileReal = new File(filePath);
	    if (!fileReal.getParentFile().exists()){
	        fileReal.getParentFile().mkdirs();
	    }
	    
	    try{
	        file.transferTo(fileReal);   //upload
	        
	        OutputStream outputStream = response.getOutputStream();
	        String s = ckeditorCallBack(CKEditorFuncNum,filePath,"");
	        byte[] bt = s.getBytes();
	        outputStream.write(bt);
	        outputStream.close();
	        
	    }catch (IOException ex){
	        logger.error("CKEditor图片上传失败！",ex);
	    }
	    
	    //return ckeditorCallBack(CKEditorFuncNum,filePath,"");
	}
	
	 @RequestMapping("download.data")    
	    public ResponseEntity<byte[]> download() throws IOException {  
	    	LocalDate localDate = new LocalDate();
	    	StringBuilder filePathBuilder = new StringBuilder(fileRoot);
			filePathBuilder.append(localDate.getYear()).append(localDate.getMonthOfYear()).append(localDate.getDayOfMonth()) //file path
			          .append("/").append("9b8361a1466a4ee7a637d3040fc87cb9_icon.png");
	    	
	    	
	        File file=new File(filePathBuilder.toString());  
	        HttpHeaders headers = new HttpHeaders();    
	        String fileName=new String("9b8361a1466a4ee7a637d3040fc87cb9_icon.png".getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
	        headers.setContentDispositionFormData("attachment", fileName);   
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
	        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
	                                          headers, HttpStatus.OK);    
	    }    
	
	public static String  ckeditorCallBack(String CKEditorFuncNum,String filePath,String info){
		StringBuilder result = new StringBuilder("<script type=\"text/javascript\">window.parent.CKEDITOR.tools.callFunction(");
		result.append(CKEditorFuncNum).append(",'").append(filePath).append("'")
			  .append(",'").append(info).append("');</script>");
		return result.toString();
	}
	
	public void setFileRoot(String fileRoot) {
		this.fileRoot = fileRoot;
	}
}
