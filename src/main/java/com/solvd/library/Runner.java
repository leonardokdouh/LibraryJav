package com.solvd.library;

import com.solvd.library.bin.ShippingType;
import com.solvd.library.bin.Users;
import com.solvd.library.services.UsersService;
import com.solvd.library.services.impl.UserServicesImpl;
import com.solvd.library.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Runner {
    private static final Scanner scan = new Scanner(System.in);
    private static final Logger LOG = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {
        UsersUtils options = new UsersUtils();
        WorkersUtils workers = new WorkersUtils();
        DomParser domOrders = new DomParser();

        ShippingType ships = new ShippingType(3L, "Flat Air");

        System.out.println(ships.getType());

        /*
        LOG.info("WELCOME TO THE LIBRARY APP" + "\n SELECT 1 for Worker" + "\n SELECT 2 for User/Customer");

        int selection = scan.nextInt();

        if (selection == 1) {
            LOG.info("WELCOME WORKER");
            int option = workers.workerOptions();
            switch (option) {
                case 1:
                    LOG.info("This are the active users:");
                    try (Connection c = ConnectionPool.getInstance().getConnection()) {
                        UsersService listUser = new UserServicesImpl(c);
                        List<Users> thisList = listUser.getAllUsers();
                        for (Users u : thisList) {
                            System.out.println(u.toString());
                        }
                    } catch (Exception e) {
                    }
                    break;
                case 2:
                    LOG.info("This are the last orders");
                    domOrders.ordersXML();
                    break;
            }
        }

        if (selection == 2) {
            int option = options.menu();
            switch (option) {
                case 1:
                    LOG.info("This are the books available right now");

                    break;

                case 2:
                    LOG.info("YOu enter 2");
                    break;

                case 3:
                    NewUserBuilder newUser = new NewUserBuilder();
                    newUser.creation();


                    LOG.info("YOu enter 3");
                    break;

                case 4:
                    LOG.info("YOu enter 4");
                    break;


            }


        }*/
    }
}
