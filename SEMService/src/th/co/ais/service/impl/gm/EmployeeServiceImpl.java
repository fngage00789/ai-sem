package th.co.ais.service.impl.gm;

import java.util.List;

import th.co.ais.dao.impl.gm.EmployeeHibernateDAO;
import th.co.ais.domain.gm.Employee;
import th.co.ais.service.AbstractService;
import th.co.ais.service.gm.IEmployeeService;

public class EmployeeServiceImpl extends AbstractService implements IEmployeeService {

	private EmployeeHibernateDAO employeeDao;
	public void setEmployeeDao(EmployeeHibernateDAO employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public List<Employee> getEmployees(Employee employee) throws Exception {
		return employeeDao.getEmployees(employee);
	}

}
