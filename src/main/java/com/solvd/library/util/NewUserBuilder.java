package com.solvd.library.util;

import com.solvd.library.bin.Users;
import com.solvd.library.services.UsersService;
import com.solvd.library.services.impl.UserServicesImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class NewUserBuilder {

    private static Scanner scan = new Scanner(System.in);
    private static final Logger LOG = LogManager.getLogger(NewUserBuilder.class);
    private String name;
    private String email;
    private int age;
    private String address;


    public void creation() {
        UsersUtils tool = new UsersUtils();

        try (Connection c = ConnectionPool.getInstance().getConnection()) {
            LOG.info("So, you are a new user, please tell me your name");
            name = scan.nextLine();

            LOG.info("Now enter your email");
            email = scan.nextLine();
            tool.checkMail(email);

            LOG.info("Now your address");
            address = scan.nextLine();

            LOG.info("And finally please tell me your age");
            age=scan.nextInt();

            UsersService up = new UserServicesImpl(c);
            Users newUser = new Users(name, email, address, age);
            up.create(newUser);

        } catch (SQLException e) {

        }

    }


}
