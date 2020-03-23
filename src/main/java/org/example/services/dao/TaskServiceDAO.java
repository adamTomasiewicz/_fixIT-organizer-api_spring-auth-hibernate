package org.example.services.dao;


import org.example.exceptions.ResourceNotFoundException;
import org.example.models.dao.TaskDAO;
import org.example.models.mappers.TaskMapper;
import org.example.repositories.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceDAO {

  private static final Logger logger = LoggerFactory.getLogger(TaskServiceDAO.class);
  private TaskRepository taskRepository;
  private TaskMapper taskMapper;

  public TaskServiceDAO(TaskRepository taskRepository, TaskMapper taskMapper) {
    this.taskRepository = taskRepository;
    this.taskMapper = taskMapper;
  }



  public TaskDAO getTaskById(Long id) {
    return taskRepository.findTaskById(id) //zwraca Optional
        .orElseThrow(() -> new ResourceNotFoundException("Not found Task by id: " + id));
  }
  public TaskDAO getTaskByUuid(String uuid) {
    return taskRepository.findTaskByUuid(uuid) //zwraca Optional
            .orElseThrow(() -> new ResourceNotFoundException("Not found Task by uuid: " + uuid));
  }

  public List<TaskDAO> getTasksAll() {
    List<TaskDAO> taskDAOs= taskRepository.findAll();
    logger.debug("Task: {}", taskDAOs);
    MDC.clear();
    return taskDAOs;
  }
  public List<TaskDAO> getTasksByName(String name) {
    return taskRepository.findTaskByName(name);
  }


  public List<TaskDAO> getTasksByUrgency(int urgency) {
    return taskRepository.findTaskByUrgency(urgency);
  }
  public List<TaskDAO> getTasksByImportance(int importance) {
    return taskRepository.findTaskByImportance(importance);
  }
  public List<TaskDAO> getTasksByColorCategory(String colorCategory) {
    return taskRepository.findTaskByColorCategory(colorCategory);
  }
}
