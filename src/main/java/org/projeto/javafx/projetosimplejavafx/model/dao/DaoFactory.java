package org.projeto.javafx.projetosimplejavafx.model.dao;

import org.projeto.javafx.projetosimplejavafx.db.DB;
import org.projeto.javafx.projetosimplejavafx.model.dao.impl.DepartmentDaoJdbc;
import org.projeto.javafx.projetosimplejavafx.model.dao.impl.SallerDaoJdbc;

public class DaoFactory {
    public static SellerDao CreateSellerDao() {
        return new SallerDaoJdbc(DB.getConnection());
    }

    public static DepartmentDao CreateDepartmentDao() {
        return new DepartmentDaoJdbc(DB.getConnection());
    }
}
