package fa.training.test;

import fa.training.repositories.CustomerRepository;
import fa.training.repositories.impl.CustomerRepositoryImpl;
import fa.training.services.CustomerService;
import fa.training.services.impl.CustomerServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VivuStore {
    private static final Logger logger = LoggerFactory.getLogger(VivuStore.class);

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();

        CustomerRepository customerRepository = new CustomerRepositoryImpl(session);
        CustomerService customerService = new CustomerServiceImpl(customerRepository);

        try {
            session.beginTransaction();

            CustomterTest customterTest = new CustomterTest();
            customterTest.testAddCustomer(session, customerService );

            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error("", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
