package org.example.controllers;

import org.example.models.dto.TaskDTO;
import org.example.services.dto.TaskServiceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskWEBController {
    private static final Logger logger = LoggerFactory.getLogger(TaskWEBController.class);
    private TaskServiceDTO taskServiceDTO;

    public TaskWEBController(TaskServiceDTO taskServiceDTO) {
        this.taskServiceDTO = taskServiceDTO;
    }

    @GetMapping("/home")
    public String getHomePage(
            Model model, @RequestParam(value = "info", required = false) String info,
            @RequestParam(value = "message", required = false) String message) {
        model.addAttribute("info", info);
        model.addAttribute("tasks", taskServiceDTO.getTasksAll());
        model.addAttribute("message", message);
        SecurityContext context = SecurityContextHolder.getContext();
        String login = context.getAuthentication().getName();
        model.addAttribute("login", "You are logged in as: " + login);
        return "index";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/task-edit")
    public String getTaskEdit(@RequestParam(value = "uuid") String uuid, Model model) {
        TaskDTO taskDTO = taskServiceDTO.getTaskByUuid(uuid);
        model.addAttribute("task", taskDTO);
        return "task-update";
    }

    @PostMapping("/task-save")
    public String getTaskSave(@ModelAttribute TaskDTO taskDTO, @RequestParam(name = "email") String email) {
        TaskDTO before = taskServiceDTO.getTaskByUuid(taskDTO.getUuid());
        before.setName(taskDTO.getName());
        before.setDescription(taskDTO.getDescription());
        before.setUrgency(taskDTO.getUrgency());
        before.setImportance(taskDTO.getImportance());
        //taskServiceDTO.updateTaskByUuid(before);
        String info = before.getName();
        return "redirect:/home?info=" + info;
    }
}