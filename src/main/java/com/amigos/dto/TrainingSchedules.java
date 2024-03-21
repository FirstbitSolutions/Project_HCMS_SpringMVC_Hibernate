package com.amigos.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TrainingSchedules")
public class TrainingSchedules {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ScheduleID")
	private int scheduleId;

	@ManyToOne
	@JoinColumn(name = "ModuleID")
	private TrainingModules trainingModule;

	@ManyToOne
	@JoinColumn(name = "TrainerID")
	private Trainers trainer;

	@Column(name = "StartDate")
	private Date startDate;

	@Column(name = "EndDate")
	private Date endDate;

	@Column(name = "Location")
	private String location;

	@Column(name = "MaxParticipants")
	private int maxParticipants;

	// Getters and setters
	public TrainingSchedules() {
		// TODO Auto-generated constructor stub
	}

	public TrainingSchedules(int scheduleId, TrainingModules trainingModule, Trainers trainer, Date startDate,
			Date endDate, String location, int maxParticipants) {
		super();
		this.scheduleId = scheduleId;
		this.trainingModule = trainingModule;
		this.trainer = trainer;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.maxParticipants = maxParticipants;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public TrainingModules getTrainingModule() {
		return trainingModule;
	}

	public void setTrainingModule(TrainingModules trainingModule) {
		this.trainingModule = trainingModule;
	}

	public Trainers getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainers trainer) {
		this.trainer = trainer;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	@Override
	public String toString() {
		return "TrainingSchedules [scheduleId=" + scheduleId + ", trainingModule=" + trainingModule + ", trainer="
				+ trainer + ", startDate=" + startDate + ", endDate=" + endDate + ", location=" + location
				+ ", maxParticipants=" + maxParticipants + "]";
	}

}