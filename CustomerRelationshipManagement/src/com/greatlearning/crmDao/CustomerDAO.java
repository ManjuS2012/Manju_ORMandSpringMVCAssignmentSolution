package com.greatlearning.crmDao;

import java.util.List;

import com.greatlearning.crmEntity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers(String sortby);

	public void saveCustomer(Customer newCustomer);

	public Customer getCustomerById(int customerId);

	public void deleteCustomerById(int customerId);

}
