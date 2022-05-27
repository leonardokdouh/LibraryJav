package com.solvd.library.services.impl;

import com.solvd.library.bin.Customers;
import com.solvd.library.dao.ICustomersDAO;
import com.solvd.library.dao.impl.CustomersDAO;
import com.solvd.library.services.CustomersService;

import java.sql.Connection;
import java.util.List;

public class CustomersServiceImpl implements CustomersService {

    private Connection conn;

    private ICustomersDAO custom = new CustomersDAO(conn);


    public CustomersServiceImpl(Connection conn) {
        this.conn = conn;

    }

    @Override
    public void delete(Long id) {
        custom.delete(id);

    }

    @Override
    public void create(Customers u) {
        custom.saveEntity(u);

    }

    @Override
    public void update(Customers entity) {
        custom.update(entity);
    }

    @Override
    public Customers getCustomers(Long id) {
        Customers cust = custom.getEntity(id);
        return cust;
    }

    @Override
    public List<Customers> getAllCustomers() {
        List<Customers> listCusto = custom.getAll();
        return listCusto;
    }
}
