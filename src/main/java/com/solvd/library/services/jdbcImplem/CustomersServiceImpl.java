package com.solvd.library.services.jdbcImplem;

import com.solvd.library.bin.Customers;
import com.solvd.library.dao.ICustomersDAO;
import com.solvd.library.dao.impl.CustomersDAO;
import com.solvd.library.services.CustomersService;

import java.sql.Connection;
import java.util.List;

public class CustomersServiceImpl implements CustomersService {


    @Override
    public void delete(Long id) {
        ICustomersDAO custom = new CustomersDAO();
        custom.delete(id);
    }

    @Override
    public void create(Customers u) {
        ICustomersDAO custom = new CustomersDAO();
        custom.saveEntity(u);

    }

    @Override
    public void update(Customers entity) {
        ICustomersDAO custom = new CustomersDAO();
        custom.update(entity);
    }

    @Override
    public Customers getCustomers(Long id) {
        ICustomersDAO custom = new CustomersDAO();
        Customers cust = custom.getEntity(id);
        return cust;
    }

    @Override
    public List<Customers> getAllCustomers() {
        ICustomersDAO custom = new CustomersDAO();

        List<Customers> listCusto = custom.getAll();
        return listCusto;
    }
}
