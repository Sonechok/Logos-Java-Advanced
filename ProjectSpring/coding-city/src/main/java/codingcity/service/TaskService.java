package codingcity.service;

import codingcity.dto.TaskDTO;
import codingcity.entity.Task;

import java.util.List;

public interface TaskService {
    TaskDTO createTask (TaskDTO taskDTO, Long courseId);

    List<Task> findAllByCourseId(Long courseId);

    Task findById(Long taskId);
}
