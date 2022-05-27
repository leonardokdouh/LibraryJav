package com.solvd.library.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class WorkersUtils {
    private static final Logger LOG = LogManager.getLogger(WorkersUtils.class);
    private final Scanner scanner = new Scanner(System.in);

    public int workerOptions() {
        int option = 1;
        LOG.info("\nChose the option below:\n" + "Opcion 1:CHECK ACTIVE USERS\n" +
                "Option 2: CHECK ACTIVE ORDERS\n" + "Option 3: CHECK LAST ORDERS\n" +
                "Option 4: CHECK LAS CARGOES\n" +
                "Option 5: CHECK ACTUAL SHIFTS\n" +
                "Option 6: CREATE A WORKER\n" + "Option 7: CHECK ACTIVE WORKERS\n");
        option = scanner.nextInt();
        return option;
    }

}
