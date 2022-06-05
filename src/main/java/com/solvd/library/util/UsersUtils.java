package com.solvd.library.util;

import com.solvd.library.bin.PayMethod;
import com.solvd.library.bin.ShippingType;
import com.solvd.library.util.exceptions.ExceptionChoose;
import com.solvd.library.util.exceptions.ExceptionMail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class UsersUtils {
    private static final Logger LOG = LogManager.getLogger(UsersUtils.class);
    private final Scanner scanner = new Scanner(System.in);

    public int menu() {
        {
            int option = 1;
            LOG.debug("\nChose the option below:\n" + "Opcion 1: BUY A BOOK\n"
                    + "Option 2:REGISTRY USER\n"
                    + "Option 3:CHECK Pay and Ship Methods \n " + "Option 4:CHECK BOOKS FOR SALE \n "
                    + "Option 5:CHECK BOOKS FOR LEND \n ");

            try {
                option = scanner.nextInt();

            } catch (InputMismatchException e) {
                LOG.debug("Dear User, i asume you want to buy a book");
            }
            if (option > 8) {
                throw new ExceptionChoose("\n" + "You enter a invalid option. Come back later");
            }
            return option;

        }
    }

    public void checkMail(String mail) throws ExceptionMail {
        AtomicInteger arroba = new AtomicInteger();
        AtomicBoolean dot = new AtomicBoolean(false);


        if (mail.length() <= 2) {
            throw new ExceptionMail("\n" + "You have to write better");
        } else {
            IntStream.range(0, mail.length()).forEach(p -> {

                if (mail.charAt(p) == '@') {
                    arroba.getAndIncrement();
                }
                if (mail.charAt(p) == '.') {
                    dot.set(true);
                }
            });
        }
        if (dot.get() && arroba.get() == 1) {
            LOG.debug("Thank you sir for your email");
        } else {
            LOG.debug("That mail is incorrect. No problem.");
        }
    }

    public void payAndShips() {
        PayMethod cash = new PayMethod(1L, "Cash");
        PayMethod debit = new PayMethod(2L, "Debit");
        PayMethod credit = new PayMethod(3L, "Credit");
        List<PayMethod> payMethods = new ArrayList<>();
        payMethods.add(cash);
        payMethods.add(debit);
        payMethods.add(credit);

        ShippingType firstShip = new ShippingType(1L, "Air");
        ShippingType secondShip = new ShippingType(2L, "Boat");
        ShippingType thirdShip = new ShippingType(3L, "Drone");
        List<ShippingType> typeShipping = new ArrayList<>();
        typeShipping.add(firstShip);
        typeShipping.add(secondShip);
        typeShipping.add(thirdShip);

        for (ShippingType ship : typeShipping) {
            LOG.info(ship.toString());
        }
        for (PayMethod u : payMethods) {
            LOG.info(u.toString());


        }
    }

}


