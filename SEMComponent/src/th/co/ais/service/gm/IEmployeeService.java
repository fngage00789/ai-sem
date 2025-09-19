package th.co.ais.service.gm;

import java.util.List;
import th.co.ais.domain.gm.Employee;
import th.co.ais.service.BaseService;

public interface IEmployeeService extends BaseService {

	public List<Employee> getEmployees(final Employee employee) throws Exception;
	
}
