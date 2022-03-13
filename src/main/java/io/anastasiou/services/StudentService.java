package io.anastasiou.services;

import io.anastasiou.models.Student;
import io.anastasiou.repositories.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements EntityService<Student> {
    private EntityRepository<Student> repository;

    @Autowired
    public StudentService(EntityRepository<Student> repository) {
        this.repository = repository;
    }

    public Student findById(Integer id) {
        return repository.getById(id);
    }

    public List<Student> find() {
        return repository.getAll();
    }

    public void add(Student student) {
        repository.create(student);
    }

    public void edit(Student student) {
        repository.update(student);
    }

    public void remove(Student student) {
        repository.delete(student);
    }
}
