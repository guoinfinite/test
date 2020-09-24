package guojing.pro.mapper;

import guojing.pro.entity.Department;

import java.util.List;

/**
 * @author guojing
 * @version 1.0
 * @date 2020/9/24 下午12:11
 */
public interface DepartmentMapper {

	int save(Department dept);

	int deleteById(Long id);

	int updateDept(Department dept);

	Department getDept(Long id);

	List<Department> getAllDept();

	/**
	 * 删除时将父节点为id的dept的父ID设置为0
	 * @param id
	 * @return
	 */
	int updateParent(Long id);
}
