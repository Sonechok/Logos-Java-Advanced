package logos.springcore.repository;

import logos.springcore.entity.Student;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    List<Student> findByName(String name);
}
