package com.solvd.library;

import com.solvd.library.bin.Customers;
import com.solvd.library.bin.LendsDetail;
import com.solvd.library.bin.OrdersDetails;
import com.solvd.library.services.CustomersService;
import com.solvd.library.services.UsersService;
import com.solvd.library.services.WorkersService;
import com.solvd.library.services.jaxBParser.JaxB;
import com.solvd.library.services.jdbcImplem.UserServicesImpl;
import com.solvd.library.services.myBatis.CustomersServiceImplementation;
import com.solvd.library.services.myBatis.UserServiceImplementation;
import com.solvd.library.services.myBatis.WorkersServiceImplementation;
import com.solvd.library.util.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class App {
    private static final Logger LOG = LogManager.getLogger(App.class);

    public static void main(String[] args) throws IOException {


        JaxB service = new JaxB();
        OrdersDetails orderS = service.unmarshall(Constants.JAXB);
        LOG.info(orderS);


        /*UsersService userJdbc = new UserServicesImpl();
        WorkersService works = new WorkersServiceImplementation();
        LOG.info(works.getAllWorkers());
        LOG.info(works.getWorker(2L).getName());*/
        //works.delete(2L);
        //I can delete everyone who dont have a relation with other table
        // For example : id 7L
        //Cannot delete or update a parent row: a foreign key constraint fails
        /*LOG.info(works.getAllWorkers());

        LOG.info(userJdbc.getUsers(30L));
        LOG.info(userJdbc.getAllUsers());*/
        //userJdbc.delete(3L);

//        CustomersServiceImplementation customerMyBatis = new CustomersServiceImplementation();
//        LOG.info(customerMyBatis.getAllCustomers());
//        Customers newCustomer = new Customers("Leonel ", "leonel@gmail.com", 36);
//        customerMyBatis.create(newCustomer);
//        LOG.info(customerMyBatis.getAllCustomers());
//        customerMyBatis.delete(7L); //since id has AI yo need to change the id to try it
//        LOG.info(customerMyBatis.getAllCustomers());
//


//        try {
//            Users u = new Users("Tarja", "asdasdtarke@gmail.com", "Lili 4th Ave.", 55);
//
//                //userMyBatis.create(u);
//               //userMyBatis.delete(4L);
//        }catch (Exception e){
//            LOG.error(e);
//        }

//        UserServiceImplementation userMyBatis = new UserServiceImplementation();
//
//        LOG.error(userMyBatis.getUsers(30L).toString());
//        LOG.info(userMyBatis.getAllUsers());


        //JaxB jaxbServ = new JaxB();
        //LendsDetail jaxb = jaxbServ.unmarshall("C:\\User");


        //user.getAllUsers();


        /*List <Users> theList = userDAO.getAll();
        for (Users u : theList) {
            LOG.info(u.toString());
        }*
           /*
        List<Users> thisList = listUser.getAllUsers();
        for (Users u : thisList){
            LOG.info(u.toString());*/

        }
 }

     /*
        try (Connection c = ConnectionPool.getInstance().getConnection()) {

            if (c != null) {
                LOG.info("You are inside now");
            } else {
                LOG.info("You did not Connect to the server");
            }

            holis.creation();

            // get all service method
            UsersService listUser = new UserServicesImpl(c);
            List <Users> thisList = listUser.getAllUsers();
            for (Users u : thisList){
                LOG.info(u.toString());
            }

            // get 1 user method
            UsersService userGet = new UserServicesImpl(c);
            Users newUser = userGet.getUsers(3L);
            LOG.info(newUser.toString());

            //Create user method
            UsersService up = new UserServicesImpl(c);
            Users lili = new Users("Mery", "mery@gmail.com", "4th Av ", 55);
            up.create(lili);

            //Delete User
            UsersService down = new UserServicesImpl(c);
           //down.delete(L); add the id number inside the ()


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {

        }

    }
}*/
