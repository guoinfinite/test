package guojing.pro.services.impl;

import guojing.pro.entity.Employee;
import guojing.pro.mapper.EmployeeMapper;
import guojing.pro.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guojing
 * @version 1.0
 * @date 2020/9/24 上午10:37
 */
@Service
public class EmployeeServicesImpl implements EmployeeServices {

	@Autowired
	private EmployeeMapper employeeMapper;

	/**
	 * 首次添加将员工状态职为1
	 *
	 * @param employee
	 * @return
	 */
	@Override
	public int addEmployee(Employee employee) {
		employee.setStatus(1);
		return employeeMapper.addEmployee(employee);
	}

	@Override
	public int deleteEmployeeById(Long id) {
		return employeeMapper.deleteEmployeeById(id);
	}

	@Override
	public int updateEmployee(Employee employee) {
		return employeeMapper.updateEmployee(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeMapper.getEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeMapper.getAllEmployee();
	}
}
