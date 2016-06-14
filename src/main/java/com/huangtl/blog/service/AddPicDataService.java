package com.huangtl.blog.service;
//package com.coder6.blog.service;
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Service;
//
//import com.weimingfj.common.dao.impl.JdbcDaoImpl;
//import com.weimingfj.common.form.RequestDataForm;
//import com.weimingfj.common.form.ResponseDataForm;
//import com.weimingfj.common.service.IServiceCallback;
//
//@Service("addDriverService")
//public class AddPicDataService implements IServiceCallback {
//
//	@Resource
//	private JdbcDaoImpl jdbcDao;
//
//	@Override
//	/**
//	 * service回调函数，执行传统sql xml无法解决的问题，如第三方接口回调等
//	 * 
//	 * @param requestDataForm
//	 * @param responseDataForm
//	 * @throws Exception
//	 */
//	public ResponseDataForm serviceCallback(RequestDataForm requestDataForm)
//			throws Exception {
//		ResponseDataForm rdf = new ResponseDataForm();
//		String defualt_prefix = requestDataForm.getString("defualt_prefix");
//		String driverId = requestDataForm.getString("driverId");
//		int maxImgNum = requestDataForm.getInteger(defualt_prefix+"_"+"maxImgNum");
//		//-------------处理附件-----------------------
//		for(int i=0;i<maxImgNum;i++){
//			//添加副表
//			if(!"".equals(requestDataForm.getString("img_"+i)) && requestDataForm.getString("img_"+i)!=null){
//				String value = requestDataForm.getString("img_"+i);
//				String[] val = value.split("~");
//				String code = val[0];
//				String path = val[1];
//				String remote_path = requestDataForm.getString("remote_img_"+i);
//				
//				jdbcDao.execute("insert into tab_driver_pic(pic_id,driver_id,pic_type,pic_local_url,pic_remote_url,upload_time) "
//						+ "values(UUID(),?,?,?,?,now())",
//						new Object[]{driverId,code,path,remote_path});
//			}
//		}
//		rdf.setResult(ResponseDataForm.SESSFUL);
//		return rdf;
//
//	}
//}
