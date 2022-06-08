package com.egroup.test.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egroup.test.app.dao.*;
import com.egroup.test.app.entity.*;

@Service
public class DeveloperService {

	@Autowired
	private DeveloperDao developerDao;

	public DeveloperEntity add(String name) {
		DeveloperEntity developer = new DeveloperEntity(name);
		return developerDao.save(developer);
	}

	public List<DeveloperEntity> getDevelopers() {
		return developerDao.findAll();
	}

	public Optional<DeveloperEntity> getById(Integer id) {
		return developerDao.findById(id);
	}

	public DeveloperEntity update(DeveloperEntity developer) {
		return developerDao.save(developer);
	}

	public void delete(Integer developerId) {
		developerDao.deleteById(developerId);
	}

	public Long getDeveloperCount() {
		return developerDao.count();
	}
}
