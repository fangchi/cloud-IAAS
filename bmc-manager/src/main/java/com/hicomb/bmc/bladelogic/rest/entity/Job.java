package com.hicomb.bmc.bladelogic.rest.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Job {
	private String objectId;
	private String modelType;
	private String url;
	private String name;
	private String description;
	private String dbkey;
	private String userCreated;
	private Date dateCreated;
	private String priority;
	private String jobTimeout;
	
	private Map<String,Object> properties = new HashMap<String,Object>();

	public Job(String objectId) {
		super();
		this.objectId = objectId;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserCreated() {
		return userCreated;
	}

	public void setUserCreated(String userCreated) {
		this.userCreated = userCreated;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getJobTimeout() {
		return jobTimeout;
	}

	public void setJobTimeout(String jobTimeout) {
		this.jobTimeout = jobTimeout;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getModelType() {
		return modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}
	
	public String getDbkey() {
		return dbkey;
	}

	public void setDbkey(String dbkey) {
		this.dbkey = dbkey;
	}

	public Map<String,Object> getProperties() {
		return properties;
	}

	public void addProperty(String name,Object value) {
		properties.put(name, value);
	}
	
}
