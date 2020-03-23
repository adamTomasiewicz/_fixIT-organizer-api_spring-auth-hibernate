package org.example.controllers;

import org.example.models.dto.TaskDTO;
import org.example.services.TaskService;
import org.example.services.dto.TaskServiceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin //front/rest
@RestController
@RequestMapping("/api/dto")
public class TaskDTORestController implements TaskService<TaskDTO> {
    private static final Logger logger = LoggerFactory.getLogger(TaskDTORestController.class);

    private TaskServiceDTO taskServiceDTO;
    public TaskDTORestController(TaskServiceDTO taskServiceDTO) {
        this.taskServiceDTO = taskServiceDTO;
    }

    @Override
    public TaskDTO getTaskByUuid(String uuid) {
        return null;
    }

    @Override
    @GetMapping("/tasks")
    public List<TaskDTO> getTasksAll() {
        return taskServiceDTO.getTasksAll();
    }

    @Override
    @GetMapping("/tasks/name/{name}")
    public List<TaskDTO> getTasksByName(@PathVariable String name) {
        return taskServiceDTO.getTasksByName(name);
    }

    @Override
    public List<TaskDTO> getTasksByDescription(String description) {
        return null;
    }

    @Override
    public List<TaskDTO> getTasksByColorCategory(String colorCategory) {
        return null;
    }

    @Override
    @GetMapping("/tasks/urgency/{urgency}")
    public List<TaskDTO> getTasksByUrgency(@PathVariable int urgency) {
        return taskServiceDTO.getTasksByUrgency(urgency);
    }
    @Override
    @GetMapping("/tasks/importance/{importance}")
    public List<TaskDTO> getTasksByImportance(@PathVariable int importance) {
        return taskServiceDTO.getTasksByImportance(importance);
    }

    @Override
    public List<TaskDTO> getTasksByCreateLocalDateTime(Date date) {
        return null;
    }


    /**CRUD*/
    @Override
    @PostMapping("/tasks")
    public void addTask(@RequestBody TaskDTO taskDTO) {
        taskServiceDTO.addTask(taskDTO);
    }
    @Override
    @PutMapping("/tasks")
    public void updateTaskByUuid(String uuid) {
    }
    @Override
    @DeleteMapping("/tasks")
    public void deleteTaskByUuid(@RequestParam(value = "delete") String uuid) {
        taskServiceDTO.deleteTaskByUuid(uuid);

    }

}