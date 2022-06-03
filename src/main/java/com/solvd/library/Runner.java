package com.solvd.library;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.library.bin.*;
import com.solvd.library.services.*;
import com.solvd.library.services.domParser.DomParser;
import com.solvd.library.services.jdbcImplem.*;
import com.solvd.library.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
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
                    UsersService listUser = new UserServicesImpl();
                    List<Users> thisList = listUser.getAllUsers();
                    for (Users u : thisList) {
                        LOG.info(u.toString());
                    }
                    break;

                case 2:
                    LOG.info("This are the active orders");
                    try {
                        JavaType secodType = om.getTypeFactory().constructCollectionType(List.class, Orders.class);
                        List orders = om.readValue(new File(Constants.JSON_CERO), secodType);
                        LOG.info(orders);
                    } catch (IOException e) {
                        LOG.error("IOException", e);
                    }
                    break;

                case 3:
                    LOG.info("This is the last order");
                    domOrders.ordersXML();
                    break;

                case 4:
                    LOG.info("This are the last cargoes");
                    try {
                        JavaType type = om.getTypeFactory().constructCollectionType(List.class, Cargoes.class);

                        List cargos = om.readValue(new File(Constants.JSON_ONE), type);
                        LOG.info(cargos);

                    } catch (IOException e) {
                        LOG.error("There was a problem in: ", e);
                    }
                    break;

                case 5:
                    LOG.info("This are the actual shifts");
                    try {
                        JavaType thirdType = om.getTypeFactory().constructCollectionType(List.class, Shifts.class);
                        List shifts = om.readValue(new File(Constants.JSON_TWO), thirdType);
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
                    WorkersService listWorkers = new WorkersServiceImpl();
                    List<Workers> thisOtherList = listWorkers.getAllWorkers();
                    for (Workers u : thisOtherList) {
                        LOG.info(u.toString());
                    }
                    break;
            }
        }

        if (selection == 2) {
            int option = options.menu();
            switch (option) {
                case 1:
                    LOG.info("This are the books available right now");
                    BooksService booksUser = new BooksServiceImp();
                    List<Books> thisList = booksUser.getallBooks();
                    for (Books u : thisList) {
                        LOG.info(u.toString());
                    }
                    break;

                case 2:
                    LOG.info("This are the books to Lend right now: ");
                    break;

                case 3:
                    HumansBuilder newUser = new HumansBuilder();
                    newUser.userCreation();
                    break;

                case 4:
                    LOG.info("This are the payment Methods and Shipping Types");
                    UsersUtils pays = new UsersUtils();
                    pays.payAndShips();

                    break;
                case 5:
                    LOG.info("This are the books available for Sale");
                    BooksForSaleService booksSale = new BooksForSaleServiceImp();
                    List<BooksForSale> thisListSale = booksSale.getAllBooks();
                    for (BooksForSale u : thisListSale) {
                        LOG.info(u.toString());
                    }
                    break;

                case 6:
                    LOG.info("This are the books available for Lends");
                    BooksForLendsService boksLends = new BooksForLendServiceImpl();
                    List<BooksForLend> thisListLend = boksLends.getAllBooks();
                    for (BooksForLend u : thisListLend) {
                        LOG.info(u.toString());
                    }
                    break;

            }


        }
    }
}
