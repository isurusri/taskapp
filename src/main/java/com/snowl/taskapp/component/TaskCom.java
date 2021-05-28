package com.snowl.taskapp.component;

import com.snowl.taskapp.data.Task;
import com.snowl.taskapp.dto.TaskDto;
import com.snowl.taskapp.repo.TaskRepo;
import com.snowl.taskapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TaskCom implements TaskService {
    @Autowired
    private TaskRepo taskRepo;

    @Override
    public List<TaskDto> findAll() {
        List<Task> tasks = taskRepo.findAll();
        List<TaskDto> dtos = new ArrayList<>();

        for (Task task : tasks
        ) {
            TaskDto dto = new TaskDto();

            dto.setId(task.getId());
            dto.setText(task.getText());
            dto.setDate(task.getDate());
            dto.setReminder(task.isReminder());

            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepo.findById(id);
    }


    @Override
    public TaskDto createTask(TaskDto task) {
        Task t = new Task();

        t.setText(task.getText());
        t.setDate(task.getDate());
        t.setReminder(task.isReminder());

        Task task1 = taskRepo.save(t);
        task.setId(task1.getId());

        return task;
    }

    @Override
    public void deleteById(Long id) {
        taskRepo.deleteById(id);
    }


    @Override
    @Transactional
    public Optional<Task> updateReminder(Long id, boolean reminder) {
        taskRepo.updateReminder(id, reminder);
        return findById(id);
    }
}
