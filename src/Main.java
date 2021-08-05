import business.concretes.CustomerCheckManager;
import business.concretes.CustomerManager;
import business.concretes.MailVerificationService;
import dataAccess.concretes.HibernateCustomerDao;
import entities.concretes.Customer;

public class Main {

    public static void main(String[] args) {
        Customer customer1 = new Customer();
        customer1.setCustomerId(1);
        customer1.setFirstName("Mehmet Ali");
        customer1.setLastName("Çelik");
        customer1.setEmail("ma@hotmail.com");
        customer1.setPassword("123456");

        Customer customer2 = new Customer();
        customer2.setCustomerId(2);
        customer2.setFirstName("ayşe");
        customer2.setLastName("şahin");
        customer2.setEmail("difk@hotmail.com");
        customer2.setPassword("123456");

        Customer customer3 = new Customer();
        customer3.setCustomerId(3);
        customer3.setFirstName("emre");
        customer3.setLastName("ay");
        customer3.setEmail("aeay@hotmail.com");
        customer3.setPassword("123456");

        CustomerManager customerManager = new CustomerManager(new HibernateCustomerDao(),new MailVerificationService(), new CustomerCheckManager());

        customerManager.signUp(customer1);
        customerManager.signUp(customer2);
    }
}
