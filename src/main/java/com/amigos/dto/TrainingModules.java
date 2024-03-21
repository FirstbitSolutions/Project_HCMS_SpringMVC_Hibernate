package com.amigos.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TrainingModules")
public class TrainingModules {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ModuleID")
	private int moduleId;

	@Column(name = "ModuleName")
	private String moduleName;

	@Column(name = "Description")
	private String description;

	@Column(name = "Duration")
	private int duration;

	// Getters and setters
	public TrainingModules() {
		// TODO Auto-generated constructor stub
	}

	public TrainingModules(int moduleId, String moduleName, String description, int duration) {
		super();
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.description = description;
		this.duration = duration;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "TrainingModules [moduleId=" + moduleId + ", moduleName=" + moduleName + ", description=" + description
				+ ", duration=" + duration + "]";
	}

}
