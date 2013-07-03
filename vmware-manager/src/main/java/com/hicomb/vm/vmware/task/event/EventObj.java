package com.hicomb.vm.vmware.task.event;

import java.util.Date;

import com.vmware.vim25.ManagedObjectReference;

/**
 * 事件对象
 */
public class EventObj {
	
	/*VM uuid*/
	private String objId;
	
	/*事件ID*/
	private Integer eventId;
	
	/*类名称*/
	private String className;
	
	/*类型*/
	private String eventType;
	
	/*事件内容*/
	private String fullFormattedMessage;
	
	/*关联的对象*/
	private String referenceStr;
	
	/*发生时间*/
	private Date createTime;
	
	/*reference*/
	private ManagedObjectReference srcManagedObjectReference;
	
	public EventObj(){
		super();
	}
	
	public EventObj(String objId, Integer eventId, String className, String eventType, String fullFormattedMessage, String referenceStr,Date createTime){
		super();
		this.objId = objId;
		this.eventId = eventId;
		this.className = className;
		this.eventType = eventType;
		this.fullFormattedMessage = fullFormattedMessage;
		this.referenceStr = referenceStr;
		this.createTime = createTime;
	}

	public String getObjId() {
		return objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getFullFormattedMessage() {
		return fullFormattedMessage;
	}

	public void setFullFormattedMessage(String fullFormattedMessage) {
		this.fullFormattedMessage = fullFormattedMessage;
	}

	public String getReferenceStr() {
		return referenceStr;
	}

	public void setReferenceStr(String referenceStr) {
		this.referenceStr = referenceStr;
	}

	public ManagedObjectReference getSrcManagedObjectReference() {
		return srcManagedObjectReference;
	}

	public void setSrcManagedObjectReference(
			ManagedObjectReference srcManagedObjectReference) {
		this.srcManagedObjectReference = srcManagedObjectReference;
	}
}
