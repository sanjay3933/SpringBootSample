package com.egroup.test.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.egroup.test.app.entity.DeveloperEntity;

@RestController
@RequestMapping("/developer")
public class DeveloperController {

  @Autowired
  private com.egroup.test.app.service.DeveloperService developerService;

  @RequestMapping(value="list", method = RequestMethod.GET)
  public List<com.egroup.test.app.entity.DeveloperEntity> getDeveloperList() {
    return developerService.getDevelopers();
  }

  @RequestMapping(value = "create", method = RequestMethod.POST)
  public DeveloperEntity create(@RequestBody String name) {
    return developerService.add(name);
  }

  @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
  public DeveloperEntity update(@RequestBody DeveloperEntity developer) {
    return developerService.update(developer);
  }

  @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable(value = "id") Integer developerId) {
    developerService.delete(developerId);
  }
}
