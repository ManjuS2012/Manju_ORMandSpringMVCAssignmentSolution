package com.greatlearning.crmService;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.crmDao.CustomerDAO;
import com.greatlearning.crmEntity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO cdao;

	@Override
	@Transactional
	public List<Customer> getCustomers(String sortBy) {
		System.out.println("get customers");
		return cdao.getCustomers(sortBy);
	}

	@Override
	@Transactional
	public void saveCustomer(Customer newCustomer) {
		cdao.saveCustomer(newCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomerById(int customerId) {
		return cdao.getCustomerById(customerId);
	}

	@Override
	@Transactional
	public void deleteCustomerById(int customerId) {
		cdao.deleteCustomerById(customerId);
	}

}
