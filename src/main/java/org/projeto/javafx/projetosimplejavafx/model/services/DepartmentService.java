package org.projeto.javafx.projetosimplejavafx.model.services;

import org.projeto.javafx.projetosimplejavafx.model.dao.DaoFactory;
import org.projeto.javafx.projetosimplejavafx.model.dao.DepartmentDao;
import org.projeto.javafx.projetosimplejavafx.model.entities.Department;

import java.util.List;

public class DepartmentService {

    private DepartmentDao dao = DaoFactory.CreateDepartmentDao();
    public List<Department> findAll() {
       return dao.findAll();
    }
}
