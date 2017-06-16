package com.huangtl.blogmgr.model.blog;

import java.util.Date;

import com.huangtl.blogmgr.model.common.ObjectValue;

/**
 * 开发计划
 * @author Canaan
 * @date 2017年6月16日
 *
 */
public class DevelopPlan extends ObjectValue {
	private static final long serialVersionUID = -681526036491126917L;
	private String fId;
	private String fName;				//任务名称
	private Integer fPriority;			//任务优先级
	private String fDescr;				//任务描述
	private Date fFinishDate;			//任务完成时间
	private String fCreateUser;			//任务创建人
	private Date fCreateDate;			//任务创建日期
	private Integer fProgress;			//任务进度
	private String fPlanStauts;			//任务状态
	private Date fEstimatedDate;		//任务预计完成时间
	private String fPlanTerminator;		//任务完成人
	
	private String planTerminatorName;  //任务完成人名称
	private String createUserName;		//任务创建人名称
	public String getfId() {
		return fId;
	}
	public void setfId(String fId) {
		this.fId = fId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public Integer getfPriority() {
		return fPriority;
	}
	public void setfPriority(Integer fPriority) {
		this.fPriority = fPriority;
	}
	public String getfDescr() {
		return fDescr;
	}
	public void setfDescr(String fDescr) {
		this.fDescr = fDescr;
	}
	public Date getfFinishDate() {
		return fFinishDate;
	}
	public void setfFinishDate(Date fFinishDate) {
		this.fFinishDate = fFinishDate;
	}
	public String getfCreateUser() {
		return fCreateUser;
	}
	public void setfCreateUser(String fCreateUser) {
		this.fCreateUser = fCreateUser;
	}
	public Date getfCreateDate() {
		return fCreateDate;
	}
	public void setfCreateDate(Date fCreateDate) {
		this.fCreateDate = fCreateDate;
	}
	public Integer getfProgress() {
		return fProgress;
	}
	public void setfProgress(Integer fProgress) {
		this.fProgress = fProgress;
	}
	public String getfPlanStauts() {
		return fPlanStauts;
	}
	public void setfPlanStauts(String fPlanStauts) {
		this.fPlanStauts = fPlanStauts;
	}
	public Date getfEstimatedDate() {
		return fEstimatedDate;
	}
	public void setfEstimatedDate(Date fEstimatedDate) {
		this.fEstimatedDate = fEstimatedDate;
	}
	public String getfPlanTerminator() {
		return fPlanTerminator;
	}
	public void setfPlanTerminator(String fPlanTerminator) {
		this.fPlanTerminator = fPlanTerminator;
	}
	public String getPlanTerminatorName() {
		return planTerminatorName;
	}
	public void setPlanTerminatorName(String planTerminatorName) {
		this.planTerminatorName = planTerminatorName;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
}
