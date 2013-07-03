package com.hicomb.cloud.rest.sce.entity.event;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * SCE 事件Obj
 */
public class SmartCloudEntryEvent {

	/*事件编号*/
	private String eventId;
	
	/*消息内容*/
	private String message;
	
	/*类型*/
	private String eventType;
	
	/*关联资源*/
	private List<Map> relatedResource = new ArrayList<Map>();
	
	/*安全级别*/
	private String severity;
	
	/*发生时间*/
	private Date occurTime;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public List<Map> getRelatedResource() {
		return relatedResource;
	}

	public void setRelatedResource(List<Map> relatedResource) {
		this.relatedResource = relatedResource;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public Date getOccurTime() {
		return occurTime;
	}

	public void setOccurTime(Date occurTime) {
		this.occurTime = occurTime;
	}
}
