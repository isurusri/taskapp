package com.snowl.taskapp.repo;

import com.snowl.taskapp.data.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {

    @Modifying
    @Query("update Task t set t.reminder = :reminder where t.id = :id")
    void updateReminder(@Param(value = "id") long id, @Param(value = "reminder") boolean reminder);

}
