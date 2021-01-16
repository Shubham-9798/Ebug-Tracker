package com.Ebug.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ebug.entity.CriticalLevel_Table;

public interface CriticalLevel_Repository  extends JpaRepository<CriticalLevel_Table, Long> {

}