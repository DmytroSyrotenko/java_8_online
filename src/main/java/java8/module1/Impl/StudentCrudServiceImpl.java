package java8.module1.Impl;

import java8.module1.Impl.interfaces.StudentCrudService;
import java8.module1.db.Db;
import java8.module1.entity.Student;

public class StudentCrudServiceImpl implements StudentCrudService {


    Db db = new Db();

    @Override
    public void create(Student student) {
        db.createStudent(student);
        System.out.println("Student created");
    }

    @Override
    public void update(Student student) {
        db.updateStudent(student);
    }

    @Override
    public void delete(String id) {
        db.deleteStudent(id);
    }

    @Override
    public Student findOne(String id) {
        return db.findOneStudent(id);
    }

    @Override
    public Student[] findAll() {
        return db.findAllStudents();
    }
}