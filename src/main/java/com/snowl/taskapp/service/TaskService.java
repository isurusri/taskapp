package com.snowl.taskapp.service;

import com.snowl.taskapp.data.Task;
import com.snowl.taskapp.dto.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TaskService {
    List<TaskDto> findAll();

    Optional<Task> findById(Long id);

    TaskDto createTask(TaskDto task);

    void deleteById(Long id);

    Optional<Task> updateReminder(Long id, boolean reminder);

}
