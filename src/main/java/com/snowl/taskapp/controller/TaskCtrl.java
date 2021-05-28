package com.snowl.taskapp.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.snowl.taskapp.data.Task;
import com.snowl.taskapp.dto.TaskDto;
import com.snowl.taskapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("api/task")
public class TaskCtrl {
    @Autowired
    private TaskService taskService;

    @GetMapping("/get")
    private List<TaskDto> all() {
        return taskService.findAll();
    }

    @GetMapping("/find")
    private Optional<Task> findOne(@RequestParam("id") Long id) {
        return taskService.findById(id);
    }

    @PostMapping("/create")
    private TaskDto createTask(@RequestBody TaskDto task) {
        return taskService.createTask(task);
    }

    @PutMapping("/update")
    private Optional<Task> updateTask(@RequestParam("id") Long id, @RequestParam("reminder") boolean reminder) {
        taskService.updateReminder(id, reminder);
        return findOne(id);
    }

    @DeleteMapping("/delete")
    void deleteTask(@RequestParam("id") Long id) {
        taskService.deleteById(id);
    }

}
