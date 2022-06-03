package com.solvd.library.services.myBatis;

import com.solvd.library.bin.Customers;
import com.solvd.library.dao.ICustomersDAO;
import com.solvd.library.services.CustomersService;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CustomersServiceImplementation extends AbsSqlSession implements CustomersService {

    private static final Logger LOG = LogManager.getLogger(CustomersServiceImplementation.class);

    @Override
    public void delete(Long id) {
        try (SqlSession session = sqlSession();) {
            ICustomersDAO customers = session.getMapper(ICustomersDAO.class);
            customers.delete(id);
            session.commit();

        }
    }

    @Override
    public void create(Customers u) {
        try (SqlSession session = sqlSession();) {
            ICustomersDAO customers = session.getMapper(ICustomersDAO.class);
            customers.saveEntity(u);
            session.commit();

        }
    }

    @Override
    public void update(Long id, Customers entity) {
        try (SqlSession session = sqlSession();) {
            ICustomersDAO customers = session.getMapper(ICustomersDAO.class);
            customers.update(id, entity);
            session.commit();
        }
    }

    @Override
    public Customers getCustomers(Long id) {
        try (SqlSession session = sqlSession();) {
            ICustomersDAO customers = session.getMapper(ICustomersDAO.class);
            Customers custom = customers.getEntity(id);
            return custom;
        }
    }

    @Override
    public List<Customers> getAllCustomers() {
        try (SqlSession session = sqlSession();) {
            ICustomersDAO customers = session.getMapper(ICustomersDAO.class);
            List<Customers> listCustomers = customers.getAll();
            return listCustomers;
        }
    }
}
