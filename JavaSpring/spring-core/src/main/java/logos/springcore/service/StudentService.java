package logos.springcore.service;

import logos.springcore.entity.Student;

import java.util.List;

public interface StudentService extends CrudService<Student, Integer> {
    List<Student> findByName (String name);
}
