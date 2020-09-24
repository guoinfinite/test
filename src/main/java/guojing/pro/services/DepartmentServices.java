package guojing.pro.services;

import guojing.pro.entity.Department;

import java.util.List;

/**
 * @author guojing
 * @version 1.0
 * @date 2020/9/24 下午2:36
 */
public interface DepartmentServices {

	/**
	 * 查询部门+
	 * @param id
	 * @return
	 */
	Department getDept(Long id);

	List<Department> getAllDept();

	int save(Department dept);

	int update(Department dept);

	int deleteById(Long id);
}
