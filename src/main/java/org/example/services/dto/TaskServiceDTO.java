package org.example.services.dto;

import org.example.exceptions.ResourceNotFoundException;
import org.example.models.dao.TaskDAO;
import org.example.models.dto.TaskDTO;
import org.example.models.mappers.TaskMapper;
import org.example.repositories.TaskRepository;
import org.example.services.TaskService;
import org.example.services.dao.TaskServiceDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceDTO implements TaskService<TaskDTO> {

  private static final Logger logger = LoggerFactory.getLogger(TaskServiceDTO.class);
  private TaskRepository taskRepository;
  private TaskMapper taskMapper;

  public TaskServiceDTO(TaskRepository taskRepository, TaskMapper taskMapper) {
    this.taskRepository = taskRepository;
    this.taskMapper = taskMapper;
  }




  @Override
  public TaskDTO getTaskByUuid(String uuid) {
      Optional<TaskDAO> taskDAO = taskRepository.findTaskByUuid(uuid);
      return taskMapper.map(taskDAO.get());
    }

  @Override
  public List<TaskDTO> getTasksAll() {
      return taskRepository.findTasksAll()
              .stream()
              .map(taskMapper::map)
              .collect(Collectors.toList());
  }

  @Override
  public List<TaskDTO> getTasksByName(String name) {
    return taskRepository.findTaskByName(name)
            .stream()
            .map(taskMapper::map)
            .collect(Collectors.toList());
  }

  @Override
  public List<TaskDTO> getTasksByDescription(String words) {
    return taskRepository.findTaskByDescription(words)
            .stream()
            .map(taskMapper::map)
            .collect(Collectors.toList());
  }
  @Override
  public List<TaskDTO> getTasksByColorCategory(String colorCategory) {
    return taskRepository.findTaskByColorCategory(colorCategory)
            .stream()
            .map(taskMapper::map)
            .collect(Collectors.toList());
  }

  @Override
  public List<TaskDTO> getTasksByUrgency(int urgency) {
    return null;
  }

  @Override
  public List<TaskDTO> getTasksByImportance(int importance) {
    return null;
  }


  @Override
  public List<TaskDTO> getTasksByCreateLocalDateTime(Date date) {
    return taskRepository.findTaskByCreateLocalDateTime(date)
            .stream()
            .map(taskMapper::map)
            .collect(Collectors.toList());
  }


//  @Override
//  public List<TaskDTO> getTasksByListDatesIn(List<LocalDateTime> listOfDates) {
//    return null;
//  }


/**CRUD*/
  @Override
  public void addTask(TaskDTO taskDTO) {
    TaskDAO taskDAO = new TaskDAO();
    taskDAO.setUuid(UUID.randomUUID().toString());
    taskDAO.setName(taskDTO.getName());
    taskDAO.setDescription(taskDTO.getDescription());
    taskDAO.setUrgency(taskDTO.getUrgency());
    taskDAO.setImportance(taskDTO.getImportance());
    taskDAO.setColorCategory(taskDTO.getColorCategory());
    taskDAO.setTagStrings(taskDTO.getTags());

    taskRepository.save(taskDAO);
  }

  @Override
  public void updateTaskByUuid(String uuid) {
    TaskDTO taskDTO = new TaskDTO();
    System.out.println(taskDTO);
    Optional<TaskDAO> before = taskRepository.findTaskByUuid(taskDTO.getUuid());
    before.orElseThrow(() -> new ResourceNotFoundException("Task not found"));
    before.get().setName(taskDTO.getName());
    before.get().setDescription(taskDTO.getDescription());
    before.get().setUrgency(taskDTO.getUrgency());
    before.get().setImportance(taskDTO.getImportance());
    before.get().setColorCategory(taskDTO.getColorCategory());
    before.get().setTagStrings(taskDTO.getTags());
    taskRepository.save(before.get());
    taskMapper.map(before.get());
  }
  @Override
  public void deleteTaskByUuid(String uuid) {
    taskRepository.deleteTaskByUuid(uuid);
  }



}
