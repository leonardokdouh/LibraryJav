package com.solvd.library.util;

import com.solvd.library.bin.Users;
import com.solvd.library.bin.Workers;
import com.solvd.library.services.UsersService;
import com.solvd.library.services.WorkersService;
import com.solvd.library.services.impl.UserServicesImpl;
import com.solvd.library.services.impl.WorkersServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class HumansBuilder {

    private static Scanner scan = new Scanner(System.in);
    private static final Logger LOG = LogManager.getLogger(HumansBuilder.class);
    private String name;
    private String email;
    private int age;
    private String address;
    private String gender;
    private int shifts;


    public void userCreation() {
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
            age = scan.nextInt();

            UsersService up = new UserServicesImpl(c);
            Users newUser = new Users(name, email, address, age);
            up.create(newUser);

        } catch (SQLException e) {

        }
    }
        public void workerCreation() {
            try (Connection c = ConnectionPool.getInstance().getConnection()) {
                LOG.info("You are about to create a Worker. Enter the name");
                name = scan.nextLine();

                LOG.info("Enter gender");
                 gender= scan.nextLine();

                LOG.info("Enter the shift id");
                shifts = scan.nextInt();

                WorkersService up = new WorkersServiceImpl(c);
                Workers newW = new Workers(name, gender,shifts);
                up.create(newW);

                LOG.info(newW.toString());

            } catch (SQLException e) {

            }

            }
    }

