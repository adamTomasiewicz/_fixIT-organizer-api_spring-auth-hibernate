package org.example.controllers;

import org.apache.commons.lang3.StringUtils;
import org.example.models.dao.TaskDAO;
import org.example.services.dao.TaskServiceDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dao")
public class TaskDAORestController {
    private static final Logger logger = LoggerFactory.getLogger(TaskDAORestController.class);

    private TaskServiceDAO taskServiceDAO;

    public TaskDAORestController(TaskServiceDAO taskServiceDAO) {
        this.taskServiceDAO = taskServiceDAO;
    }


    @GetMapping("/tasks/id/{id}")
    public ResponseEntity<TaskDAO> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskServiceDAO.getTaskById(id));
    }

    @GetMapping("/tasks/uuid/{uuid}")
    public ResponseEntity<TaskDAO> getTaskByUuid(@PathVariable String uuid) {
        return ResponseEntity.ok(taskServiceDAO.getTaskByUuid(uuid));
    }

    @GetMapping("/tasks/name/{name}")
    public ResponseEntity<List<TaskDAO>> getTasksByName(@PathVariable String name) {
        return ResponseEntity.ok(taskServiceDAO.getTasksByName(name));
    }


//    @GetMapping("/tasks")
//    public ResponseEntity<List<TaskDAO>> getTasksByUrgencyAndImportance(
//            @RequestParam(required = false) int urgency,
//            @RequestParam(required = false) int importance) {
//        if (urgency != 0 && urgency != 0) {
//            return ResponseEntity.ok(taskServiceDAO.getTasksByUrgencyAndImportance(urgency, importance));
//        }
//        return ResponseEntity.ok(taskServiceDAO.getTasksAll());
//    }
}