package com.solvd.library.dao.impl;

import com.solvd.library.bin.Customers;
import com.solvd.library.dao.ICustomersDAO;
import com.solvd.library.util.ExceptionDAO;
import com.solvd.library.util.OneStepCloser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomersDAO implements ICustomersDAO {

    final String INSERT = "INSERT INTO Customers (id, name, email, age) VALUES (?,?,?,?)";
    final String UPDATE = "UPDATE Customers SET name=?, email =?, age=? WHERE id=?";
    final String DELETE = "DELETE Customers WHERE id=?";
    final String GETALL = "SELECT id, name, email, age FROM Customers";
    final String GETONE = "SELECT id, name, email, age FROM Customers WHERE id=?";

    private Connection conn;

    public CustomersDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void saveEntity(Customers entity) throws ExceptionDAO {
        PreparedStatement ps = null;
        OneStepCloser close = new OneStepCloser(null);

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
            throw new ExceptionDAO("Error in SQL sentence", e);
        } finally {
            close.theCloser(ps);
        }
    }

    @Override
    public void update(Customers entity) throws ExceptionDAO {
        PreparedStatement ps = null;
        OneStepCloser close = new OneStepCloser(null);

        try {
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getEmail());
            ps.setInt(3, entity.getAge());

            if (ps.executeUpdate() == 0) {
                throw new ExceptionDAO("Maybe your changes may not be saved");
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Maybe your changes may not be saved");
        } finally {
            close.theCloser(ps);
        }
    }

    @Override
    public void delete(Customers id) throws ExceptionDAO {

        PreparedStatement ps = null;
        OneStepCloser end = new OneStepCloser(null);
        try {
            ps = conn.prepareStatement(DELETE);
            ps.setLong(1, id.getId());
            if (ps.executeUpdate() == 0) {
                throw new ExceptionDAO("Maybe the User has not been deleted");
            }

        } catch (SQLException e) {
            throw new ExceptionDAO("Maybe its not deleted", e);
        } finally {
            end.theCloser(ps);
        }
    }

    private Customers convert(ResultSet rs) throws SQLException {

        Long id = rs.getLong("id");
        String name = rs.getString("name");
        String email = rs.getString("email");
        int age = rs.getInt("age");

        Customers cust = new Customers(id, name, email, age);
        return cust;
    }


    @Override
    public Customers getEntity(Long id) throws ExceptionDAO {
        OneStepCloser close = new OneStepCloser(null, null);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Customers cu = null;

        try {
            ps = conn.prepareStatement(GETONE);
            rs = ps.executeQuery();

            if (rs.next()) {
                cu = convert(rs);
            } else {
                throw new ExceptionDAO("The id is not in the database");
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Error in SQL", e);
        } finally {
            close.twoCloser(ps, rs);
        }
        return cu;
    }

    @Override
    public List<Customers> getAll() throws ExceptionDAO {
        OneStepCloser close = new OneStepCloser(null, null);
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Customers> cuList = new ArrayList<>();

        try {
            ps = conn.prepareStatement(GETONE);
            rs = ps.executeQuery();

            while (rs.next()) {
                cuList.add(convert(rs));
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Error in SQL", e);
        } finally {
            close.twoCloser(ps, rs);
        }
        return cuList;
    }
}
