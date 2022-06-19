package com.solvd.library.dao.impl;

import com.solvd.library.bin.Customers;
import com.solvd.library.util.exceptions.ExceptionDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomersDAO extends AbsConnectionForDAO implements com.solvd.library.dao.ICustomersDAO {
    private static final Logger LOG = LogManager.getLogger(Customers.class);

    private final String INSERT = "INSERT INTO Customers (name, email, age) VALUES (?,?,?)";
    private final String UPDATE = "UPDATE Customers SET name=?, email =?, age=? WHERE id=?";
    private final String DELETE = "DELETE Customers WHERE id=?";
    private final String GET_ALL = "SELECT id, name, email, age FROM Customers";
    private final String GET_ONE = "SELECT id, name, email, age FROM Customers WHERE id=?";


    @Override
    public void saveEntity(Customers entity){
        PreparedStatement ps = null;
        Connection conn = getConnect();
        try {
            ps = conn.prepareStatement(INSERT);
            ps.setLong(1, entity.getId());
            ps.setString(2, entity.getName());
            ps.setString(3, entity.getEmail());
            ps.setInt(4, entity.getAge());
            if (ps.executeUpdate() == 0) {
                throw new ExceptionDAO("I think that the customer did not saved");
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Error in SQL sentence");
        } finally {
            returnConnect(conn);
            closeAllResources(ps);
        }
    }

    @Override
    public void update(Long id, Customers entity){
        PreparedStatement ps = null;
        Connection conn = getConnect();
        try {
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getEmail());
            ps.setInt(3, entity.getAge());
            ps.setLong(4, id);
            if (ps.executeUpdate() == 0) {
                throw new ExceptionDAO("Maybe your changes may not be saved");
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Maybe your changes may not be saved");
        } finally {
            returnConnect(conn);
            closeAllResources(ps);
        }
    }

    @Override
    public void delete(Long id){
        PreparedStatement ps = null;
        Connection conn = getConnect();
        try {
            ps = conn.prepareStatement(DELETE);
            ps.setLong(1, id);
            if (ps.executeUpdate() == 0) {
                throw new ExceptionDAO("Maybe the User has not been deleted");
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Maybe its not deleted");
        } finally {
            returnConnect(conn);
            closeAllResources(ps);
        }
    }

    private Customers convert(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        String email = rs.getString("email");
        int age = rs.getInt("age");
        Customers newCustomer = new Customers(name, email, age);
        newCustomer.setId(rs.getLong("id"));
        return newCustomer;
    }

    @Override
    public Customers getEntity(Long id){
        PreparedStatement ps = null;
        Connection conn = getConnect();
        ResultSet rs = null;
        Customers customer = null;
        try {
            ps = conn.prepareStatement(GET_ONE);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                customer = convert(rs);
            } else {
                throw new ExceptionDAO("The id is not in the database");
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Error in SQL");
        } finally {
            returnConnect(conn);
            closeAllResources(ps, rs);
        }
        return customer;
    }

    @Override
    public List<Customers> getAll(){
        PreparedStatement ps = null;
        Connection conn = getConnect();
        ResultSet rs = null;
        List<Customers> cuList = new ArrayList<>();
        try {
            ps = conn.prepareStatement(GET_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                cuList.add(convert(rs));
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Error in SQL");
        } finally {
            returnConnect(conn);
            closeAllResources(ps, rs);
        }
        return cuList;
    }
}
