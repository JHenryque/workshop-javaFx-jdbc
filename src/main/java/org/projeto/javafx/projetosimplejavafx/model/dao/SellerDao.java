package org.projeto.javafx.projetosimplejavafx.model.dao;

import org.projeto.javafx.projetosimplejavafx.model.entities.Department;
import org.projeto.javafx.projetosimplejavafx.model.entities.Seller;

import java.util.List;

public interface SellerDao {
    void insirt(Seller obj);
    void update(Seller obj);
    void deleteById(Integer id);
    Seller findById(Integer id);
    List<Seller> findAll();
    List<Seller> findByDepartment(Department department);
}
