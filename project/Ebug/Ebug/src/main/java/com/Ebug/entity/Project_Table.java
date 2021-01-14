package com.Ebug.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Project_Table {
	
@Id
private Long id;

private String projectName;

private String projectDescription;

private String projectId;

private String frontendTechno;

private String backendTechno;

private String projectManager;

public Project_Table() {
	super();
	// TODO Auto-generated constructor stub
}

public Project_Table(Long id, String projectName, String projectDescription, String projectId, String frontendTechno,
		String backendTechno, String projectManager) {
	super();
	this.id = id;
	this.projectName = projectName;
	this.projectDescription = projectDescription;
	this.projectId = projectId;
	this.frontendTechno = frontendTechno;
	this.backendTechno = backendTechno;
	this.projectManager = projectManager;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getProjectName() {
	return projectName;
}

public void setProjectName(String projectName) {
	this.projectName = projectName;
}

public String getProjectDescription() {
	return projectDescription;
}

public void setProjectDescription(String projectDescription) {
	this.projectDescription = projectDescription;
}

public String getProjectId() {
	return projectId;
}

public void setProjectId(String projectId) {
	this.projectId = projectId;
}

public String getFrontendTechno() {
	return frontendTechno;
}

public void setFrontendTechno(String frontendTechno) {
	this.frontendTechno = frontendTechno;
}

public String getBackendTechno() {
	return backendTechno;
}

public void setBackendTechno(String backendTechno) {
	this.backendTechno = backendTechno;
}

public String getProjectManager() {
	return projectManager;
}

public void setProjectManager(String projectManager) {
	this.projectManager = projectManager;
}






}
