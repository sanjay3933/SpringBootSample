package com.egroup.test.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/assign")
public class IssueAssignController {
	
	@Autowired
	private com.egroup.test.app.service.IssueAssignmentService assignmentService;
	
	@RequestMapping(value="/make", method = RequestMethod.GET)
	public void makeAssignment() {
		assignmentService.makeAssignment();
	}  
	
	@RequestMapping(value="/summary", method = RequestMethod.GET)
	public List<String> viewAssignment() {
		return assignmentService.getAssignmentSummary();
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public Map<Integer, List<com.egroup.test.app.entity.StoryIssueEntity>> getAssignmentList() {
		return assignmentService.getAssignmentList();
	}
}
