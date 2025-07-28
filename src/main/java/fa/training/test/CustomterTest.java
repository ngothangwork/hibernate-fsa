package fa.training.test;

import fa.training.entities.Customer;
import fa.training.services.CustomerService;
import org.hibernate.Session;

public class CustomterTest {

    public void testAddCustomer(Session session, CustomerService customerService) {
        customerService.createCustomer("Nguyen", "Phuong", "0909090909", "Ha Noi");
        Customer customer = new Customer("Nguyen Van", "Phuong Van", "0123456789", "Ha Nam");
        session.persist(customer);
    }
}
