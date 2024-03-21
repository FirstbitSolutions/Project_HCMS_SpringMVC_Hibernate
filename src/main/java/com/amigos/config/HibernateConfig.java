package com.amigos.config;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.amigos.dto.ApplicationStatus;
import com.amigos.dto.AppraisalForms;
import com.amigos.dto.CandidateProfiles;
import com.amigos.dto.Certifications;
import com.amigos.dto.Departments;
import com.amigos.dto.EducationDetails;
import com.amigos.dto.EmployeeManagers;
import com.amigos.dto.Employees;
import com.amigos.dto.ExternalTrainers;
import com.amigos.dto.LeaveApprovals;
import com.amigos.dto.LeaveRequests;
import com.amigos.dto.LeaveTypes;
import com.amigos.dto.Payroll;
import com.amigos.dto.Projects;
import com.amigos.dto.Roles;
import com.amigos.dto.SkillMatrix;
import com.amigos.dto.SkillUpgradation;
import com.amigos.dto.Trainers;
import com.amigos.dto.TrainingFeedback;
import com.amigos.dto.TrainingModules;
import com.amigos.dto.TrainingSchedules;
import com.amigos.dto.Users;
import com.amigos.dto.Vacancies;

@org.springframework.context.annotation.Configuration
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.amigos.dao"), @ComponentScan("com.amigos.service") })
public class HibernateConfig {

	public SessionFactory sessionFactory = null;

	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() {
		if (sessionFactory == null) {

			try {
				Configuration configuration = new Configuration();
				Properties properties = new Properties();
				properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				properties.put(Environment.URL, "jdbc:mysql://localhost:3306/hcms_new");
				properties.put(Environment.USER, "root");
				properties.put(Environment.PASS, "JaiGanpati@8");
				properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
				properties.put(Environment.SHOW_SQL, "true");
				properties.put(Environment.FORMAT_SQL, "true");
				properties.put(Environment.HBM2DDL_AUTO, "update");
				configuration.setProperties(properties);
				// mapping resources
				configuration.addAnnotatedClass(Employees.class);
				configuration.addAnnotatedClass(Departments.class);
				configuration.addAnnotatedClass(Roles.class);
				configuration.addAnnotatedClass(ApplicationStatus.class);
				configuration.addAnnotatedClass(AppraisalForms.class);
				configuration.addAnnotatedClass(CandidateProfiles.class);
				configuration.addAnnotatedClass(Certifications.class);
				configuration.addAnnotatedClass(EducationDetails.class);
				configuration.addAnnotatedClass(EmployeeManagers.class);
				configuration.addAnnotatedClass(ExternalTrainers.class);
				configuration.addAnnotatedClass(LeaveApprovals.class);
				configuration.addAnnotatedClass(LeaveRequests.class);
				configuration.addAnnotatedClass(LeaveTypes.class);
				configuration.addAnnotatedClass(Payroll.class);
				configuration.addAnnotatedClass(Projects.class);
				configuration.addAnnotatedClass(SkillMatrix.class);
				configuration.addAnnotatedClass(SkillUpgradation.class);
				configuration.addAnnotatedClass(Trainers.class);
				configuration.addAnnotatedClass(TrainingFeedback.class);
				configuration.addAnnotatedClass(TrainingModules.class);
				configuration.addAnnotatedClass(TrainingSchedules.class);
				configuration.addAnnotatedClass(Users.class);
				configuration.addAnnotatedClass(Vacancies.class);
				StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate Java Configuration Service Registry Created");
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				return sessionFactory;
			} catch (HibernateException ex) {
				ex.printStackTrace();
				return null;
			}
		}
		return sessionFactory;
	}

}
