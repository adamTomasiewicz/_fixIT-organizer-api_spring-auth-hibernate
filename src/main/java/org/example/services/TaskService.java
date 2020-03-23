package org.example.services;



import org.example.models.dao.TaskDAO;
import org.example.models.dto.TaskDTO;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TaskService<T> {

  T getTaskByUuid(String uuid);

  List<T> getTasksAll();
  List<T> getTasksByName(String name);
  List<T> getTasksByDescription(String description);
  List<T> getTasksByColorCategory(String colorCategory);
  List<T> getTasksByUrgency(int urgency);
  List<T> getTasksByImportance(int importance);
  List<T> getTasksByCreateLocalDateTime(Date date);
 // List<T> getTasksByListDatesIn(List<LocalDateTime> listOfDates);

  void addTask(T t);
  void updateTaskByUuid(String uuid);
  void deleteTaskByUuid(String uuid);



}
