package com.aums.course.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aums.course.models.Employee;
import com.aums.course.queries.Queries;
import com.aums.course.rowmapper.LoginRowMapper;
import com.aums.course.rowmapper.TrainingRowMapper;

@Repository
public class TrainingDao implements ITrainingDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	TrainingDao() {
		
	}
	
	@Override
	public void addOrUpdateTrainer(int employeeId) {
		jdbcTemplate.update(Queries.ADD_UPDATE_TRAINER, employeeId);
	}

	@Override
	public void assignTrainers(int courseId,int employeeId) {
		jdbcTemplate.update(Queries.ASSIGN_TRAINER, courseId, employeeId);
	}
	
	@Override
	public void unassignTrainers(int courseId,int trainerId) {
		jdbcTemplate.update(Queries.UNASSIGN_TRAINER, courseId, trainerId);
	}
	
	@Override
	public int validateTrainer(int trainerId) {
		return jdbcTemplate.queryForObject(Queries.VALIDATE_TRAINER, Integer.class, trainerId);
	}
	
	@Override
	public void updateTrainerStatus(int trainerId) {
		jdbcTemplate.update(Queries.UPDATE_TRAINER_STATUS, trainerId);
	}
	
	@Override
	public List<Employee> getTrainersByCourseId(int courseId) {
		return jdbcTemplate.query(Queries.GET_TRAINERS_BY_COURSE, TrainingRowMapper.TrainingRowMapperLambda ,courseId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query(Queries.GET_ALL_EMPLOYEES, TrainingRowMapper.TrainerRowMapperLambda);
		}
	
}
