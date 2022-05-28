package com.solvd.library;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.library.bin.*;
import com.solvd.library.services.*;
import com.solvd.library.services.jdbcImplem.*;
import com.solvd.library.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
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
        ObjectMapper om = new ObjectMapper();

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
                            LOG.info(u.toString());
                        }
                    } catch (Exception e) {
                    }
                    break;

                case 2:
                    LOG.info("This are the active orders");
                    try {
                        JavaType secodType = om.getTypeFactory().constructCollectionType(List.class, Orders.class);

                        List orders = om.readValue(new File("src/main/resources/ordesJson.json"), secodType);
                        LOG.info(orders);
                    } catch (IOException e) {
                        LOG.error("IOException", e);
                    }
                    break;

                case 3:
                    LOG.info("This are the last orders");
                    domOrders.ordersXML();
                    break;

                case 4:
                    LOG.info("This are the last cargoes");
                    try {
                        JavaType type = om.getTypeFactory().constructCollectionType(List.class, Cargoes.class);

                        List cargos = om.readValue(new File("src/main/resources/first.json"), type);
                        LOG.info(cargos);

                    } catch (IOException e) {
                        LOG.error("IOException", e);
                    }
                    break;

                case 5:
                    LOG.info("This are the actual shifts");
                    try {
                        JavaType thirdType = om.getTypeFactory().constructCollectionType(List.class, Shifts.class);

                        List shifts = om.readValue(new File("src/main/resources/ShiftsJson.json"), thirdType);
                        LOG.info(shifts);

                    } catch (IOException e) {
                        LOG.error("IOException", e);
                    }
                    break;

                case 6:
                    HumansBuilder newWorker = new HumansBuilder();
                    newWorker.workerCreation();
                    break;

                case 7:

                    LOG.info("This are the active Workers:");
                    try (Connection c = ConnectionPool.getInstance().getConnection()) {
                        WorkersService listWorkers = new WorkersServiceImpl(c);
                        List<Workers> thisList = listWorkers.getAllWorkers();
                        for (Workers u : thisList) {
                            LOG.info(u.toString());
                        }
                    } catch (Exception e) {
                    }
                    break;
            }
        }

        if (selection == 2) {
            int option = options.menu();
            switch (option) {
                case 1:
                    LOG.info("This are the books available right now");
                    try (Connection c = ConnectionPool.getInstance().getConnection()) {
                        BooksService booksUser = new BooksServiceImp(c);
                        List<Books> thisList = booksUser.getallBooks();
                        for (Books u : thisList) {
                            LOG.info(u.toString());
                        }
                    } catch (Exception e) {
                    }
                    break;

                case 2:
                    LOG.info("YOu enter 2");
                    break;

                case 3:
                    HumansBuilder newUser = new HumansBuilder();
                    newUser.userCreation();

                    break;

                case 4:
                    LOG.info("YOu enter 4");
                    break;


                case 5:
                    LOG.info("This are the books available for Sale");
                    try (Connection c = ConnectionPool.getInstance().getConnection()) {
                        BooksForSaleService booksSale = new BooksForSaleServiceImp(c);
                        List<BooksForSale> thisList = booksSale.getAllBooks();
                        for (BooksForSale u : thisList) {
                            LOG.info(u.toString());
                        }
                    } catch (Exception e) {
                    }
                    break;

                case 6:
                    LOG.info("This are the books available for Lends");
                    try (Connection c = ConnectionPool.getInstance().getConnection()) {
                        BooksForLendsService boksLends = new BooksForLendImpl(c);
                        List<BooksForLend> thisList = boksLends.getAllBooks();
                        for (BooksForLend u : thisList) {
                            LOG.info(u.toString());
                        }
                    } catch (Exception e) {
                    }
                    break;

            }


        }
    }
}
