package codingcity.service.impl;

import codingcity.dto.TaskDTO;
import codingcity.entity.Course;
import codingcity.entity.Task;
import codingcity.error.ResourceNotFoundException;
import codingcity.repository.CourseRepository;
import codingcity.repository.TaskRepository;
import codingcity.service.TaskService;
import codingcity.service.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final CourseRepository courseRepository;

    private final TaskMapper taskMapper;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, CourseRepository courseRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.courseRepository = courseRepository;
        this.taskMapper = taskMapper;
    }



    @Override
    @Transactional
    public TaskDTO createTask(TaskDTO taskDTO, Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(()->new ResourceNotFoundException("Id",courseId.toString()));
        Task task = taskMapper.toEntity(taskDTO);
        course.getTasks().add(task);
        courseRepository.save(course);
        return taskMapper.toDTO(task);
    }

    @Override
    @Transactional
    public List<Task> findAllByCourseId(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(()->new ResourceNotFoundException("Id",courseId.toString()));
        return new ArrayList<>(course.getTasks());
    }

    @Override
    public Task findById(Long taskId) {
        return taskRepository.findById(taskId).orElseThrow(()->new ResourceNotFoundException("task id",taskId.toString()));
    }

}
