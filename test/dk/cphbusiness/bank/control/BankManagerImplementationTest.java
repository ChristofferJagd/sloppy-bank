/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.bank.control;
import dk.cphbusiness.banking.control.BankManager;
import dk.cphbusiness.banking.control.BankManagerImplementation;
import dk.cphbusiness.banking.data.BankDataAccessor;
import dk.cphbusiness.banking.model.BaseCustomer;
import dk.cphbusiness.banking.model.Customer;
import static org.hamcrest.CoreMatchers.is;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnitRuleMockery;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Ebbe
 */
public class BankManagerImplementationTest {
    public Mockery context = new JUnitRuleMockery();
    private BankManager manager;
    
    public BankManagerImplementationTest() {
    }
    
    @Test
    public void setup()throws Exception {
        final BankDataAccessor data = context.mock(BankDataAccessor.class);
        final Customer kurt = new BaseCustomer(7, "Kurt");
        BankManager manager = new BankManagerImplementation(data);
        
        
        context.checking(new Expectations() {{
            oneOf(data).saveCustomer(with(any(Customer.class)));
            will(returnValue(kurt));
        }});
        int id = manager.createCustomer("Kurt");
        assertThat(id, is(7));
    }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
