package servicesImpl;

import enums.Gender;
import enums.Role;
import models.Customer;
import models.Product;
import models.Staff;
import models.Store;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerServicesImplTest {
    Store store1;
    double initialWalletAmount;
    double storeNewAccountBalance;
    CashierServicesImpl cashierServicesImpl;
    CustomerServicesImpl customerServicesImpl;
    Staff staff1;
    Customer customer1;
    Product product1;

    @Before
    public void setUp() throws Exception {
        store1 = new Store();
        initialWalletAmount = 1_000_000.00;
        storeNewAccountBalance = 4_000.00;
        staff1 =  new Staff(1,"johnny", Gender.MALE,"johnny@live.com","DEC-JAV-1", Role.CASHIER,"BSC",70);
        customerServicesImpl = new CustomerServicesImpl();
        cashierServicesImpl = new CashierServicesImpl();
        customer1 = new Customer(2,"dennis",Gender.MALE,"dennis@live.com");
        customer1.setWallet(initialWalletAmount);
        cashierServicesImpl.fetchProductFromStore(staff1,store1,"productData.xlsx");
        customerServicesImpl.addProductToCart(customer1,store1,5,1);


    }

    @Test
    public void addProductToCart() {
        customerServicesImpl.addProductToCart(customer1,store1,store1.getProductList()[1].getId(),1);
        assertEquals(1,customer1.getCart().size());
    }

    @Test
    public void removeProductFromCart() {
    }

    @Test
    public void checkout() {

        assertTrue(customerServicesImpl.checkout(customer1,cashierServicesImpl,store1));
    }

    @Test
    public void printReceipt() {

        assertTrue(customerServicesImpl.checkout(customer1,cashierServicesImpl,store1));
    }

}