package com.huangtl.blogmgr.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public void ckEditorImageUpload( @RequestParam(value = "upload",required = true) MultipartFile file,
	        @RequestParam(value = "CKEditorFuncNum",required = true) String CKEditorFuncNum,
	        HttpServletRequest request,
	        HttpServletResponse response){
		
		LocalDate localDate = new LocalDate();
		String date = ""+localDate.getYear()+localDate.getMonthOfYear()+localDate.getDayOfMonth();
		String fileName = uuid()+"."+StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
		
		StringBuilder filePathBuilder = new StringBuilder(fileRoot);
		filePathBuilder.append(date).append("/").append(fileName); //file name
		
	    String filePath = filePathBuilder.toString();
	    
	    File fileReal = new File(filePath);
	    if (!fileReal.getParentFile().exists()){
	        fileReal.getParentFile().mkdirs();
	    }
	    
	    PrintWriter out = null;
	    try{
	        file.transferTo(fileReal);   //upload
	        response.setContentType("text/html;charset=UTF-8");
	        out = response.getWriter();
	        StringBuilder httpFilePath = new StringBuilder(request.getContextPath());
	        httpFilePath.append("/ckeditor/image/");
	        httpFilePath.append(date).append("/").append(fileName);
	        String s = ckeditorCallBack(CKEditorFuncNum,httpFilePath.toString(),"");
	        out.print(s);
	        out.flush();
	    }catch (IOException ex){
	        logger.error("CKEditor图片上传失败！",ex);
	    }finally{
	    	if(out!=null){
	    		out.close();
	    	}
	    }
	    
	}
	
	 @RequestMapping("image/{date}/{filename}.{suffix}") 
	    public ResponseEntity<byte[]> imageDownload(
	    		@PathVariable("date")String date,@PathVariable("filename")String filename,
	    		@PathVariable("suffix")String suffix) throws IOException {  
	    	
	    	StringBuilder filePathBuilder = new StringBuilder(fileRoot);
			filePathBuilder.append(date).append("/").append(filename).append(".").append(suffix);
	    	
	        File file=new File(filePathBuilder.toString());  
	        HttpHeaders headers = new HttpHeaders();    
	        String fileName=new String(filename.getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
	        fileName+="."+suffix;
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
