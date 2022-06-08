package com.egroup.test.app.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egroup.test.app.dao.BugDao;
import com.egroup.test.app.entity.BugIssueEntity;
import com.egroup.test.app.enums.BugPriorityEnum;
import com.egroup.test.app.enums.BugStatusEnum;



@Service
public class BugService {
	
	@Autowired
	private BugDao bugDao;
	
	public List<BugIssueEntity> getBugs(){
		return bugDao.findAll();
	}
	
	public Optional<BugIssueEntity> getById(Integer id) {
		return bugDao.findById(id);
	}

	public BugIssueEntity add(BugIssueEntity bug) {
		bug.setCreationDate(Calendar.getInstance().getTime());
		return bugDao.save(bug);
	}

	public BugIssueEntity update(BugIssueEntity bug) {
		return bugDao.save(bug);
	}

	public void delete(Integer developerId) {
		bugDao.deleteById(developerId);;
	}
	
	public HashMap<Integer, String> getBugPriorityMap() {
		return (HashMap<Integer, String>) BugPriorityEnum.getMap();
	}
	
	public HashMap<Integer, String> getBugStatusMap() {
		return (HashMap<Integer, String>) BugStatusEnum.getMap();
	}

	public Optional<BugIssueEntity> getBug(Integer bugId) {
		return bugDao.findById(bugId);
	}
}
