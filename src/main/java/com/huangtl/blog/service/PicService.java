package com.huangtl.blog.service;
//package com.coder6.blog.service;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.UUID;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.commons.codec.digest.DigestUtils;
//import org.apache.commons.io.FileUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.weimingfj.common.form.RequestDataForm;
//import com.weimingfj.common.form.ResponseData;
//import com.weimingfj.common.form.ResponseDataForm;
//import com.weimingfj.common.orm.DaoHelp;
//import com.weimingfj.common.service.IService;
//import com.weimingfj.common.utils.DateUtil;
//import com.weimingfj.common.utils.ImageUtil;
//import com.weimingfj.common.web.httpobjects.HttpRequestObject;
//import com.weimingfj.jiyun.enums.SourceWay;
//import com.weimingfj.jiyun.qiniu.comm.Config;
//import com.weimingfj.jiyun.qiniu.http.Response;
//import com.weimingfj.jiyun.qiniu.storage.UploadManager;
//import com.weimingfj.jiyun.qiniu.utils.ImageToken;
//import com.weimingfj.jiyun.qiniu.utils.StringMap;
//
//@Service("picService")
//public class PicService implements IService {
//
//    @Autowired
//    DaoHelp daoHelp;
//    
//    @Autowired
//    ImageService imageService;
//
//    private UploadManager uploadManager =new UploadManager();
//    
//	@Override
//	@Transactional
//	public ResponseDataForm service(RequestDataForm requestDataForm) throws Exception {
//		ResponseDataForm rdf = new ResponseDataForm();
//		HashMap<String,Object> resultMap=new HashMap<String, Object>();
//		String defualt_prefix = requestDataForm.getString("defualt_prefix");
//		int maxFileNum = requestDataForm.getInteger(defualt_prefix+"_"+"maxFileNum");
//		for(int i=0;i<=maxFileNum;i++){
//			HashMap<String,Object> map=new HashMap<String, Object>();
//			//过滤掉删除掉的那一行的select 
//			if(!"".equals(requestDataForm.getString(defualt_prefix+"_"+"imgtype"+i)) && requestDataForm.getString(defualt_prefix+"_"+"imgtype"+i)!=null){
//				String code = requestDataForm.getString(defualt_prefix+"_"+"imgtype"+i);
//				HttpRequestObject httpRequestObject = requestDataForm.get(defualt_prefix+"_"+"imgtype_img"+i);
//				String path = saveFile(httpRequestObject);
//				if(!"jiyun".equals(path.substring(0, 5))){ 
//					if(maxFileNum!=1 || httpRequestObject.getValue().length>0){//上传了一张不合格图片（maxFileNum=1）
//						rdf.setResult(ResponseDataForm.FAULAIE);
//						rdf.setResultInfo(path);
//						return rdf;
//					}
//				}else if("jiyun".equals(path.substring(0, 5))){
//					String qiniuPath = upload(requestDataForm.getRequest(), httpRequestObject).getRsObj().toString();
//					map.put("qiniuPath", qiniuPath);
//					map.put("path", path);
//					map.put("code", code);
//					resultMap.put("pic"+i, map);
//				}
//			}
//		}
//		rdf.setResult(ResponseDataForm.SESSFUL);
//		rdf.setResultObj(resultMap);
//		return rdf;
//	}
//
//	/**
//	 * 
//	 * TODO 保存文件到本地
//	 * 作者：黄廷柳
//	 * 2016年2月25日上午9:55:40
//	 */
//	private String saveFile(HttpRequestObject httpRequestObject){
//		
//		byte[] fileByte = httpRequestObject.getValue();
//		String fileName=httpRequestObject.getFilename();
//		if (fileByte == null) {
//			return "上传的照片不能为空！";
//		}
//		if(!fileName.contains(".")){
//			return "上传格式不正确";
//		}
//		String suffix = fileName.substring(fileName.lastIndexOf("."));
//		if(!suffix.equalsIgnoreCase(".jpg") && !suffix.equalsIgnoreCase(".png") 
//				&& !suffix.equalsIgnoreCase(".bmp") && !suffix.equalsIgnoreCase(".JPEG")){
//			return "上传文件格式只能是jpg,png,jpeg,bmp！";
//		}
//		fileName=DigestUtils.md5Hex(fileName)+"_"+DateUtil.getCurrDateStr("yyyyMMddHHmmss")+fileName.substring(fileName.lastIndexOf("."));
//		String path=ImageUtil.saveImage(fileByte,"jiyun", fileName);
//		
//		return path;
//	}
//	
//	
//	/**
//	 * 
//	 * TODO 上传图片到七牛（参考 CommAppController.java）
//	 * @return ResponseData 其中包含保存的路径
//	 * 作者：黄廷柳
//	 * 2016年2月25日上午9:52:11
//	 */
//	public ResponseData upload(HttpServletRequest req, HttpRequestObject httpRequestObject) throws Exception {
//		ResponseData rdf = new ResponseData();
//		
////		DiskFileItemFactory dfif = new DiskFileItemFactory();
////		dfif.setSizeThreshold(4 * 1024 * 1024);
//		File tempDir = imageService.getTempDir(req);
////		dfif.setRepository(tempDir);
////		ServletFileUpload fileUpload = new ServletFileUpload(dfif);
//
//		Map<String, Object> params = new HashMap<String, Object>();
//		String uuid=UUID.randomUUID().toString();
//		String fileType = "";
//		String fileName =httpRequestObject.getFilename();;
//		if (fileName.lastIndexOf(".") > -1) {
//			fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
//		}
//		File file = new File(tempDir.getPath() + File.separator + uuid + "." + fileType);
//		FileOutputStream fos = new FileOutputStream(file);
//		fos.write(httpRequestObject.getValue());    
//        fos.close();  
//		params.put(fileName, file);
//		
//			
//		SourceWay sourceWay = null;
//		String source_way="0";
//		try {
//			sourceWay = SourceWay.codeOf(Integer.parseInt(source_way));
//			if (null == sourceWay) {
//				throw new RuntimeException("未知的上传来源");
//			}
//		} catch (Exception e) {
//			rdf.setResult(ResponseDataForm.FAULAIE);
//			rdf.setInfo("图片上传失败, 原因: 图片来源参数[" + source_way + "]非法.");
//			return rdf;
//		}
//		
////		Map<String, String> res = new HashMap<String, String>();
//		for (Iterator<String> it = params.keySet().iterator(); it.hasNext();) {
//			String key = it.next();
//			Object val = params.get(key);
//			if (val instanceof File) {
//				String expectKey=sourceWay+"_"+uuid + "." + fileType;//七牛上图片文件名
//				StringMap imgParam = new StringMap().put("x:foo", "foo_val");
//				String token = ImageToken.testAuth.uploadToken(ImageToken.bucket, expectKey);
//				// uploadManager.put("C:\\Users\\ge\\Pictures\\Saved Pictures\\805986652766935300.jpg", expectKey, token, params, null, true);
//				Response r=uploadManager.put((File)val, expectKey, token, imgParam, null, true);
//				//Thread.sleep(5 * 1000);
////                System.out.println(r.toString());
//				String status=String.valueOf(r.statusCode);
//				
////                System.out.println(status);
//				if("200".equals(status)){
//					rdf.setRsObj(Config.IMAGE_URL+expectKey);
//				}else{
//					File newFile = imageService.movePic(sourceWay, req, (File) val);
//					rdf.setRsObj(sourceWay + "/" + newFile.getName());
//				}
//				
//				FileUtils.forceDelete((File)val);
//				daoHelp.execute("insert into up_img_his(image_name,source_way)values(?,?)",new Object[]{expectKey,source_way});
//				//File newFile = imageService.movePic(sourceWay, req, (File) val);
//				//rdf.setRsObj(sourceWay + "/" + newFile.getName());
//			}
//		}
//		
//		rdf.setResult(ResponseDataForm.SESSFUL);
//		rdf.setInfo("图片上传成功");
//		return rdf;
//	}
//}
