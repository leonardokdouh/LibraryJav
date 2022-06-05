package com.solvd.library;

import com.solvd.library.bin.*;
import com.solvd.library.services.*;
import com.solvd.library.services.jaxBParser.JaxB;

import com.solvd.library.services.myBatis.*;

import com.solvd.library.util.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class App {
    private static final Logger LOG = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        //Trying JaxB Unmarshall.
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
        marshallLend.marshall(newOrder, "src/main/resources/newOrder.xml");

        // BooksForLend Services
        BooksForLendsService myLends = new BooksForLendServiceImpl();
        List<BooksForLend> lendLists = myLends.getAllBooks();
        for (BooksForLend books : lendLists) {
            LOG.info(books);
        }

        //BooksForSale services
        BooksForSaleService booksForSales = new BooksForSaleServiceImp();
        List<BooksForSale> saleList = booksForSales.getAllBooks();
        for (BooksForSale books : saleList) {
            LOG.info(books);
        }


        //WORKER CLASS
        //UPDATING A WORKER. If you want to update,
        //change the parameters of the Workers constructor and
        //and run all to see changes before and after
        WorkersService work = new WorkersServiceImpl();
        LOG.info("The name of the worker is:" + work.getWorker(6L).getName());
        LOG.info("The gender of the worker is:" + work.getWorker(6L).getGender());
        LOG.info("The shift of the worker is:" + work.getWorker(6L).getShifts());

        LOG.info("Now lets apply the changes");
        Workers newWork = new Workers("Frodo", "Male", 3);
        work.update(6L, newWork);

        LOG.info("The new name of the worker is:" + work.getWorker(6L).getName());
        LOG.info("The new gender of the worker is:" + work.getWorker(6L).getGender());
        LOG.info("The new shift of the worker is:" + work.getWorker(6L).getShifts());

        //GETTING ALL WORKERS
        List<Workers> workersList = work.getAllWorkers();
        for (Workers allWorkers : workersList) {
            LOG.info(allWorkers);
        }

//       //DELETING A WORKER
//        work.delete(7L);

        //GETTING AND TWO WAYS TO CREATE A USER
        //To create a new user, just change the email because it has Unique Property
//        UsersService newUser = new UserServiceImpl();
//        Users jesus = new Users("Jesus C.", "jesus@gmail.com", "Heaven Av. ", 89);
//        newUser.create(jesus);

//        UPDATING USER

        UsersService userNew = new UserServiceImpl();

        LOG.info("The name of the user is ", userNew.getUsers(30L).getName());
        LOG.info("The address of the user is ", userNew.getUsers(30L).getAddress());
        LOG.info("The email of the user is ", userNew.getUsers(30L).getEmail());
        LOG.info("The age of the user is ", userNew.getUsers(30L).getAge());

        Users newUser = new Users();
        newUser.setName("Ramon");
        newUser.setAddress("Forth st 369");
        newUser.setEmail("ramon@gmail.com");
        newUser.setAge(32);
        userNew.update(30L, newUser);
        LOG.info("The new name of the user is ", userNew.getUsers(30L).getName());
        LOG.info("The new address of the user is ", userNew.getUsers(30L).getAddress());
        LOG.info("The new email of the user is ", userNew.getUsers(30L).getEmail());
        LOG.info("The new age of the user is ", userNew.getUsers(30L).getAge());

        LOG.info(userNew.getAllUsers());
        List<Users> userList = userNew.getAllUsers();
        for (Users users : userList) {
            LOG.info(users);
        }

        //CREATING CUSTOMER & DELETE THEM

        CustomersService customer = new CustomersServiceImpl();
        LOG.info(customer.getAllCustomers());
        List<Customers> customersList = customer.getAllCustomers();
        for (Customers customers : customersList) {
            LOG.info(customers);
        }

        //TO CREATE Just change email since it has UNIQUE Property
        Customers newCustomer = new Customers("Leonel ", "leonel@gmail.com", 36);
//      customer.create(newCustomer);
        List<Customers> customerList = customer.getAllCustomers();
        for (Customers customers : customerList) {
            LOG.info(customers);
        }

        LOG.info("The name of the customer is:" + customer.getCustomers(3L).getName());
        LOG.info("The email of the customer is:" + customer.getCustomers(3L).getEmail());
        LOG.info("The age of the customer is:" + customer.getCustomers(3L).getAge());

//        customer.delete(7L); //since id has AI yo need to change the id to try it


        //BOOKS SERVICES GETTING ONE, UPDATING AND GETTING AGAIN

        BooksService newBook = new BooksServiceImpl();
        LOG.info("The Book name is: " + newBook.getBooks(3L).getName());
        LOG.info("The Book type is: " + newBook.getBooks(3L).getType());
        LOG.info("The Book cargoesId is: " + newBook.getBooks(3L).getCargoesId());
        //change something to apply an update
        Books newsBook = new Books();
        newsBook.setType("paperback");
        newsBook.setName("Last Order");
        newsBook.setCargoesId(2L);
        newBook.update(3L, newsBook);
        LOG.info(newBook.getBooks(3L));

        LOG.info("The Book new name is: " + newBook.getBooks(3L).getName());
        LOG.info("The Book new type is: " + newBook.getBooks(3L).getType());
        LOG.info("The Book new cargoesId is: " + newBook.getBooks(3L).getCargoesId());


    }
}





