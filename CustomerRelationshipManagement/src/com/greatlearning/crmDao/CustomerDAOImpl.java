package com.greatlearning.crmDao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.crmEntity.Customer;
import com.greatlearning.crmUtil.SortUtils;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers(String sortby) {
		Session session = sessionFactory.getCurrentSession();
		String sortField = null;

		switch (sortby) {
		case SortUtils.FIRST_NAME:
			sortField = "firstName";
			break;
		case SortUtils.LAST_NAME:
			sortField = "lastName";
			break;
		case SortUtils.EMAIL:
			sortField = "email";
			break;
		default:
			sortField = "lastName";
		}
		System.out.println("Customer DAO implementation");
		String sql = "from Customer order by " + sortField;

		System.out.println("sql string " + sql);

		Query<Customer> getCustomerQuery = session.createQuery(sql, Customer.class);

		System.out.println("getCustomerQuery " + getCustomerQuery);

		List<Customer> customers = getCustomerQuery.getResultList();
		System.out.println("Return  customer" + customers);
		return customers;
	}

	@Override
	public void saveCustomer(Customer newCustomer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(newCustomer);
	}

	@Override
	public Customer getCustomerById(int customerId) {
		return sessionFactory.getCurrentSession().get(Customer.class, customerId);
	}

	@Override
	public void deleteCustomerById(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		Customer delCustomer = session.get(Customer.class, customerId);
		session.delete(delCustomer);
	}

}
