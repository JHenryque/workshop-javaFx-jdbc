package org.projeto.javafx.projetosimplejavafx.model.dao;

import org.projeto.javafx.projetosimplejavafx.model.entities.Department;

import java.util.List;

public interface DepartmentDao {
    void insirt(Department obj);
    void update(Department obj);
    void deleteById(Integer id);
    Department findById(Integer id);
    List<Department> findAll();
}
