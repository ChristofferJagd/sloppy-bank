package dk.cphbusiness.banking.control;

import dk.cphbusiness.banking.control.dto.CustomerDTO;
import dk.cphbusiness.banking.data.BankDataAccessor;
import dk.cphbusiness.banking.model.Account;
import dk.cphbusiness.banking.model.BaseCustomer;
import dk.cphbusiness.banking.model.Customer;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Ebbe
 */
public class BankManagerImplementation implements BankManager {

    private BankDataAccessor data;

    public BankManagerImplementation(BankDataAccessor data) {
        this.data = data;
    }

    @Override
    public int createCustomer(String name) {
        Customer cust = new BaseCustomer(0, name);
//       cust = BankDataAccessorStub.getInstance().saveCustomer(cust);
//       cust = BankDataAccessor.instance.saveCustomer(cust);
        cust = data.saveCustomer(cust);
        return cust.getId();
    }

    private CustomerDTO createCustomerDTO(Customer cust) {
        int balance = 0;
        for (Account account : cust.listAccounts()) {
            balance += account.getBalance();
        }
        return new CustomerDTO(cust.getId(), cust.getName(), balance);
    }

    @Override
    public Collection<CustomerDTO> listCustomers() {
        Collection<CustomerDTO> dtos = new ArrayList();
        for (Customer cust : data.listCustomers()) {
            dtos.add(createCustomerDTO(cust));
        }
        return dtos;
    }

    @Override
    public String createAccont(int customerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean transferAmount(String sourceNumber, String targetNumber, int amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
