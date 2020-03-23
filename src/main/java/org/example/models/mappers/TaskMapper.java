package org.example.models.mappers;

import org.example.models.dao.TaskDAO;
import org.example.models.dto.TaskDTO;
import org.example.utils.Mapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper implements Mapper<TaskDAO, TaskDTO> {


  @Override
  public TaskDTO map(TaskDAO from) {
    return TaskDTO
        .builder()
        .uuid(from.getUuid())
        .name(from.getName())
        .description(from.getDescription())
        .urgency(from.getUrgency())
        .importance(from.getImportance())
            .colorCategory(from.getColorCategory())
            .tags(from.getTagStrings())
            .createLocalDateTime(from.getCreateLocalDateTime())
            .listOfLocalDateTimes(from.getListOfLocalDateTimes())
        .build();
  }

  @Override
  public TaskDAO revers(TaskDTO to) {
   TaskDAO taskDAO = new TaskDAO();
    taskDAO.setUuid(to.getUuid());
    taskDAO.setName(to.getName());
    taskDAO.setDescription(to.getDescription());
    taskDAO.setUrgency(to.getUrgency());
     taskDAO.setImportance(to.getImportance());
     taskDAO.setColorCategory(to.getColorCategory());
     taskDAO.setTagStrings(to.getTags());
     taskDAO.setCreateLocalDateTime(to.getCreateLocalDateTime());
     taskDAO.setListOfLocalDateTimes(to.getListOfLocalDateTimes());
     return taskDAO;
  }


}
