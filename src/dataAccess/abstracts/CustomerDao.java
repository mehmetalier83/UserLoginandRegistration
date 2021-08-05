package dataAccess.abstracts;

import entities.concretes.Customer;

import java.util.List;

public interface CustomerDao {
    void add(Customer customer);
    void update(Customer customer);
    void delete(Customer customer);
    boolean getEmail(String email);
    boolean getPassword(String email);
    List<Customer> getAll();
}
