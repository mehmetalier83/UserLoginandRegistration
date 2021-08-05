package dataAccess.concretes;

import dataAccess.abstracts.CustomerDao;
import entities.concretes.Customer;

import java.util.List;

public class HibernateCustomerDao implements CustomerDao {
    @Override
    public void add(Customer customer) {

    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public boolean getEmail(String email) {
        return false;
    }

    @Override
    public boolean getPassword(String email) {
        return false;
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }
}
