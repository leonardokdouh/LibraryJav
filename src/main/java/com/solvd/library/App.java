package com.solvd.library;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.solvd.library.bin.Cargoes;
import com.solvd.library.bin.Users;
import com.solvd.library.services.UsersService;
import com.solvd.library.services.impl.UserServicesImpl;
import com.solvd.library.util.ConnectionPool;
import com.solvd.library.util.NewUserBuilder;
import com.solvd.library.util.exceptions.ExceptionMail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.rowset.CachedRowSet;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.List;

public class App {
    private static final Logger LOG = LogManager.getLogger(App.class);


    public static void main(String[] args) throws IOException {


        ObjectMapper om = new ObjectMapper();


        try {
            JavaType type = om.getTypeFactory().constructCollectionType(List.class, Cargoes.class);
            LOG.info("HIIIII");

            Cargoes cargos = om.readValue(new File("src/main/resources/first.json"), type);
            LOG.info(cargos);

        } catch (Exception e) {
            e.printStackTrace();
        }
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
                System.out.println(u.toString());
            }

            // get 1 user method
            UsersService userGet = new UserServicesImpl(c);
            Users newUser = userGet.getUsers(3L);
            System.out.println(newUser.toString());

            //Create user method
            UsersService up = new UserServicesImpl(c);
            Users lili = new Users("Mery", "mery@gmail.com", "4th Av ", 55);
            up.create(lili);
            LOG.info("THe new user was created with id: ");

            //Delete User
            UsersService down = new UserServicesImpl(c);
           down.delete(14L);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {

        }

    }
}*/
