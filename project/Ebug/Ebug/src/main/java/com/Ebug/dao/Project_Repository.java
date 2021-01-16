package com.Ebug.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ebug.entity.Project_Table;
import com.Ebug.entity.Status_Table;

public interface Project_Repository extends JpaRepository<Project_Table, Long> {
	Optional<Project_Table> findById(Long id);
}