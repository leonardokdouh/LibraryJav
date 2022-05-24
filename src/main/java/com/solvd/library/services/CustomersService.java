package com.solvd.library.services;

import com.solvd.library.bin.Customers;
import com.solvd.library.bin.Workers;

import java.util.List;

public interface CustomersService {

    void delete(Long id);

    void create (Customers u);

    void update(Customers entity);

    Customers getCustomers (Long id);

    List<Customers> getAllCustomers();
}
