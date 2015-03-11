package dk.cphbusiness.banking.view;

import dk.cphbusiness.banking.control.BankManager;
import dk.cphbusiness.banking.control.dto.CustomerDTO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Ebbe
 */
public class BankConsole {

    private BankManager manager;
    private boolean running = true;

    public BankConsole(BankManager manager) {
        this.manager = manager;
    }

    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to Ebbe's bank of tax evasion");
        try {
            while (running) {
                System.out.print("Enter Command: ");
                String line = in.readLine();
                int id = manager.createCustomer(line);
                System.out.println("The new customer has id #" + id);
                System.out.println();
                for (CustomerDTO cust : manager.listCustomers()) {
                    System.out.println(">> " + cust.getId() + " " + cust.getName() + " " + cust.getTotal());
                }
                System.out.println();
            }
        } catch (IOException ioe) {
            System.err.println("FETS ARE COMMING!!!! RUUUUUUUUUUUUN!!!!!!!!!!!");
        }
    }

}
