package io.anastasiou.repositories;

import io.anastasiou.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Repository
public class StudentRepository implements EntityRepository<Student> {
    private final SessionFactory factory;

    public StudentRepository() {
        factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }

    public List<Student> getAll() {
        try(Session session = factory.openSession();) {
            session.beginTransaction();

            Query query = session.createQuery("from Student");
            List<Student> students = query.list();

            session.getTransaction().commit();

            return students;
        }
    }

    public Student getById(Integer id) {
        try(Session session = factory.openSession();) {
            session.beginTransaction();

            Student student = session.get(Student.class, id);

            session.getTransaction().commit();

            return student;
        }
    }

    public void create(Student student) {
        try(Session session = factory.openSession();) {
            session.beginTransaction();

            session.save(student);

            session.getTransaction().commit();
        }
    }

    public void update(Student student) {
        try(Session session = factory.openSession();) {
            session.beginTransaction();

            session.update(student);

            session.getTransaction().commit();
        }
    }

    public void delete(Student student) {
        try(Session session = factory.openSession();) {
            session.beginTransaction();

            session.delete(student);

            session.getTransaction().commit();
        }
    }
}
