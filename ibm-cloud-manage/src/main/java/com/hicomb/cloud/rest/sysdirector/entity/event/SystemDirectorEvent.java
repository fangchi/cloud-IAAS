package com.hicomb.cloud.rest.sysdirector.entity.event;

import java.util.Date;

/**
 * SystemDirector事件
 */
public class SystemDirectorEvent {

	/*事件ID*/
	private String eventId;
	
	/*资源ID*/
	private String resId;
	
	/*组建类型*/
	private String componentType;

	/*事件内容*/
	private String content;
	
	/*安全级别*/
	private String severity;
	
	/*发生时间*/
	private Date occurTime;

	/*主机IP地址*/
	private String resHostIp;
	
	/*关联资源IP*/
	private String resIp;
	
	/*资源描述*/
	private String resDescription;
	
	/*资源展现名称*/
	private String resDisplayName;
	
	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getComponentType() {
		return componentType;
	}

	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	public String getResHostIp() {
		return resHostIp;
	}

	public void setResHostIp(String resHostIp) {
		this.resHostIp = resHostIp;
	}

	public String getResIp() {
		return resIp;
	}

	public void setResIp(String resIp) {
		this.resIp = resIp;
	}

	public String getResDescription() {
		return resDescription;
	}

	public void setResDescription(String resDescription) {
		this.resDescription = resDescription;
	}

	public String getResDisplayName() {
		return resDisplayName;
	}

	public void setResDisplayName(String resDisplayName) {
		this.resDisplayName = resDisplayName;
	}
}
