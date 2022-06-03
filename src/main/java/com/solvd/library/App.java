package com.solvd.library;

import com.solvd.library.bin.*;
import com.solvd.library.services.CustomersService;
import com.solvd.library.services.UsersService;
import com.solvd.library.services.WorkersService;
import com.solvd.library.services.jaxBParser.JaxB;
import com.solvd.library.services.jdbcImplem.CustomersServiceImpl;
import com.solvd.library.services.jdbcImplem.UserServicesImpl;
import com.solvd.library.services.jdbcImplem.WorkersServiceImpl;
import com.solvd.library.services.myBatis.CustomersServiceImplementation;
import com.solvd.library.services.myBatis.UserServiceImplementation;
import com.solvd.library.services.myBatis.WorkersServiceImplementation;
import com.solvd.library.util.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class App {
    private static final Logger LOG = LogManager.getLogger(App.class);

    public static void main(String[] args){

        //Trying JaxB Unmarshall. Date problems.

        JaxB service = new JaxB();
        OrdersDetails orderS = service.unmarshall(Constants.JAXB);
        LOG.info(orderS);


        //Marshalling

        JaxB marshallLend = new JaxB();
        OrdersDetails newOrder = new OrdersDetails();
        newOrder.setBooksForSaleId(3L);
        newOrder.setWorkersId(2L);
        newOrder.setShippingTypeId(3);
        newOrder.setPayMethodId(2);
        newOrder.setAddress("22 5th Aveniu, New York, USA");
        newOrder.setTotalOrder(120);
        marshallLend.marshall(newOrder,"src/main/resources/newOrder.xml");

        //JDBC WORKER CLASS
        //UPDATING A WORKER. Only run once. If you want to run again,
        //change the parameters of the Workers constructor.
        WorkersService work = new WorkersServiceImpl();

        LOG.info("The name of the worker is:" + work.getWorker(6L).getName());
        LOG.info("The gender of the worker is:" + work.getWorker(6L).getGender());
        LOG.info("The shift of the worker is:" + work.getWorker(6L).getShifts());

        LOG.info("Now lets apply the changes");
        Workers newWork = new Workers("Gloria", "Female", 3);
        work.update(6L, newWork);

        LOG.info("The name of the worker is:" + work.getWorker(6L).getName());
        LOG.info("The gender of the worker is:" + work.getWorker(6L).getGender());
        LOG.info("The shift of the worker is:" + work.getWorker(6L).getShifts());

        //GETTING ALL WORKERS
        LOG.info(work.getAllWorkers());

        //DELETING A WORKER
        work.delete(7L);


        //MYBATIS WORKER CLASS
        //REPEATING SAME metologies
        WorkersService works = new WorkersServiceImplementation();
        LOG.info("The name of the worker is:" + works.getWorker(6L).getName());
        LOG.info("The gender of the worker is:" + works.getWorker(6L).getGender());
        LOG.info("The shift of the worker is:" + works.getWorker(6L).getShifts());

        LOG.info("Now lets apply the changes");
        Workers worker = new Workers("Gladys", "Female", 2);
        works.update(6L, worker);

        LOG.info("The name of the worker is:" + works.getWorker(6L).getName());
        LOG.info("The gender of the worker is:" + works.getWorker(6L).getGender());
        LOG.info("The shift of the worker is:" + works.getWorker(6L).getShifts());

        //GETTING ALL WORKERS
        LOG.info(works.getAllWorkers());


        //GETTING AND CREATING USER WITH JDBC AND myBATIS

        UsersService upJdbc = new UserServicesImpl();
        Users jesus = new Users("Jesus C.", "jesus@gmail.com", "Heaven Av. ", 89);
        upJdbc.create(jesus);


        UsersService userJdbc = new UserServicesImpl();
        UsersService userBatis = new UserServiceImplementation();
        LOG.info(userJdbc.getUsers(30L));
        Users newUser = new Users();
        newUser.setName("Carlos");
        newUser.setAddress("Five Street 369");
        newUser.setEmail("carlos@gmail.com");
        newUser.setAge(33);
        userJdbc.update(30L, newUser);

        LOG.info(userBatis.getUsers(30L));
        Users batisUser = new Users("Jamal", "jamal@gmail.com", "Json Street 233", 14);
        userBatis.create(batisUser);
        LOG.info(userBatis.getAllUsers());


        CustomersService customerMyBatis = new CustomersServiceImplementation();
        CustomersService customerJdbc = new CustomersServiceImpl();
        LOG.info(customerMyBatis.getAllCustomers());
        Customers newCustomer = new Customers("Leonel ", "leonel@gmail.com", 36);
        customerMyBatis.create(newCustomer);
        LOG.info(customerMyBatis.getAllCustomers());
        customerMyBatis.delete(7L); //since id has AI yo need to change the id to try it
        LOG.info(customerMyBatis.getAllCustomers());






    }
}





