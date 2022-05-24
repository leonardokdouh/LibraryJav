package com.solvd.library.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class WorkersUtils {
    private static final Logger LOG = LogManager.getLogger(WorkersUtils.class);
    private final Scanner scanner = new Scanner(System.in);

    public int workerOptions(){
        int option=1;
        LOG.debug("\nChose the option below:\n" + "Opcion 1:CHECK ACTIVE USERS\n" + "Option 2: CHECK LAST ORDERS");
        option= scanner.nextInt();
        return option;
    }

    public void newOrder (){





    }

}
