package com.egroup.test.app.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egroup.test.app.dao.StoryDao;
import com.egroup.test.app.dto.DeveloperPointsDto;
import com.egroup.test.app.entity.StoryIssueEntity;
import com.egroup.test.app.enums.StoryEstimatedPointEnum;
import com.egroup.test.app.enums.StoryStatusEnum;

@Service
public class StoryService {
	
	@Autowired
	private StoryDao storyDao;
	
	public List<StoryIssueEntity> getStories(){
		return storyDao.findAll();
	}
	
	public Optional<StoryIssueEntity> getById(Integer id) {
		return storyDao.findById(id);
	}

	public StoryIssueEntity add(StoryIssueEntity story) {
		story.setCreationDate(Calendar.getInstance().getTime());
		return storyDao.save(story);
	}

	public StoryIssueEntity update(StoryIssueEntity story) {
		return storyDao.save(story);
	}

	public void delete(Integer developerId) {
		storyDao.deleteById(developerId);;
	}
	
	public List<Integer> getEstimatedPointList() {
		return StoryEstimatedPointEnum.getList();
	}
	
	public BigInteger getEstimatedStoryPoints() {
		return storyDao.getEstimatedStoryPoints();
	}
	
	public HashMap<Integer, String> getStoryStatusMap() {
		return (HashMap<Integer, String>) StoryStatusEnum.getMap();
	}

	public Optional<StoryIssueEntity> getStory(Integer storyId) {
		return storyDao.findById(storyId);
	}
	
	public Map<Integer, StoryIssueEntity> getEstimatedStories() {
		Map<Integer, StoryIssueEntity> result = new HashMap<Integer, StoryIssueEntity>();
		for (StoryIssueEntity story : storyDao.getEstimatedStories()) {
			result.put(story.getId(), story);
		}
		return result;
	}

	public Long getEstimatedPointCountForWeek(Integer weekNumber) {
		return storyDao.getEstimatedPointCountForWeek(weekNumber);
		
	}

	public StoryIssueEntity getStoryWithClosestPointTo(Integer remainingPoint) {
		List<StoryIssueEntity> resultList = storyDao.getStoryWithClosestPointTo(remainingPoint); 
		if(resultList.size() > 0) {
			return resultList.get(0);
		}
		return null;
	}

	public DeveloperPointsDto getMostAvailableDeveloperIdForStory(Integer week) {
		DeveloperPointsDto developerPoints = null;
		List<Object[]> queryResult = storyDao.getMostAvailableDeveloperIdForStory(week);
		if(queryResult.size() > 0) {
			Object[] tuple = (Object[]) queryResult.get(0);
			
			developerPoints = new DeveloperPointsDto();
		
			developerPoints.setDeveloperId((Integer) tuple[0]);
			if(tuple[1] != null) {
				developerPoints.setPoints(((BigInteger) tuple[1]).intValue());
			}
			else {
				developerPoints.setPoints(0);
			}
			
		}
		return developerPoints;
	}

	public Map<Integer, List<StoryIssueEntity>> getAssignmentList() {
		Map<Integer, List<StoryIssueEntity>> assignmentList = new HashMap<Integer, List<StoryIssueEntity>>();
		List<StoryIssueEntity> stories = storyDao.getAssignmentList();
		List<StoryIssueEntity> storyListForCurrentWeek;
		for (StoryIssueEntity storyItem : stories) {
			if(assignmentList.containsKey(storyItem.getAssignedWeek())) {
				storyListForCurrentWeek = assignmentList.get(storyItem.getAssignedWeek());
				storyListForCurrentWeek.add(storyItem);
			}
			else {
				storyListForCurrentWeek = new ArrayList<StoryIssueEntity>();
				storyListForCurrentWeek.add(storyItem);
				assignmentList.put(storyItem.getAssignedWeek(), storyListForCurrentWeek);
			}
		}
		return assignmentList;
	}
}
