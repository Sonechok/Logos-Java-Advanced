package logos.springcore.repository.impl;

import logos.springcore.entity.Student;
import logos.springcore.repository.StudentRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class StudentRepositoryImpl implements StudentRepository {
    private StudentRepositoryImpl(){}

    @Override
    public List<Student> findByName(String name) {
        return null;
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Optional<Student> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Integer integer) {

    }
}
