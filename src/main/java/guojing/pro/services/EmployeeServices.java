package guojing.pro.services;

import guojing.pro.entity.Employee;

import java.util.List;

/**
 * @author guojing
 * @version 1.0
 * @date 2020/9/24 上午10:35
 */
public interface EmployeeServices {

	/**
	 * 员工添加
	 * @param employee
	 * @return
	 */
	int addEmployee(Employee employee);

	/**
	 * 员工删除
	 * @param id
	 * @return
	 */
	int deleteEmployeeById(Long id);

	/**
	 * 员工修改
	 * @param employee
	 * @return
	 */
	int updateEmployee(Employee employee);

	/**
	 * 通过查
	 * @param id
	 * @return
	 */
	Employee getEmployeeById(Long id);

	List<Employee> getAllEmployee();

}
