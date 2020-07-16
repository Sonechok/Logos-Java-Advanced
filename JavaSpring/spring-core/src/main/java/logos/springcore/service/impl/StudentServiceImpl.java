package logos.springcore.service.impl;

import logos.springcore.entity.Student;
import logos.springcore.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentRepository{
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findByName(String name) {
        System.out.println("Find by name");
        return studentRepository.findByName(name);
    }

    @Override
    public void save(Student student) {
        System.out.println("Save");
        studentRepository.save(student);
    }

    @Override
    public void update(Student student) {
        System.out.println("Update");
        studentRepository.update(student);
    }

    @Override
    public List<Student> findAll() {
        System.out.println("Find all");
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Integer integer) {
        System.out.println("Find by id");
        return studentRepository.findById(integer);
    }

    @Override
    public void deleteById(Integer integer) {
        System.out.println("Delete");
        studentRepository.deleteById(integer);
    }
}
