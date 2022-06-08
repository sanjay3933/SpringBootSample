package com.egroup.test.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egroup.test.app.entity.BugIssueEntity;

@Repository
public interface BugDao extends JpaRepository<BugIssueEntity, Integer> {

	
	
}