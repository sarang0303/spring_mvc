package spring_mvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring_mvc.dto.Employee;

@Repository
public class EmployeeDao {
	@Autowired
	private EntityManager entityManager;

	public Employee saveEmployee(Employee employee) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;

	}

	public Employee loginEmployee(Employee employee) {
		Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE e.email=?1");
		query.setParameter(1, employee.getEmail());
		try {
			Employee dbemployee = (Employee) query.getSingleResult();
			if (employee.getPassword().equals(dbemployee.getPassword())) {
				return dbemployee;

			} else {
				return null;

			}
		} catch (Exception e) {
			System.out.println("Enter a Valid Email & password");
			return null;
		}

	}

	public List<Employee> getAllEmployee() {
		Query query = entityManager.createQuery("SELECT e FROM Employee e ");

		return query.getResultList();
	}

	public Employee deleteEmployee(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		if (employee != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			return employee;
		} else {
			return null;
		}

	}

	public Employee findEmployee(int id) {
		return entityManager.find(Employee.class, id);

	}

	public Employee updateEmployee(Employee employee) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
		return employee;

	}

}
