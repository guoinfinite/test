package guojing.pro.services.impl;

import guojing.pro.entity.Department;
import guojing.pro.mapper.DepartmentMapper;
import guojing.pro.services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guojing
 * @version 1.0
 * @date 2020/9/24 下午2:37
 */
@Service
public class DepartmentServicesImpl implements DepartmentServices {

	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
	public Department getDept(Long id) {
		return departmentMapper.getDept(id);
	}

	@Override
	public List<Department> getAllDept() {
		return departmentMapper.getAllDept();
	}

	@Override
	public int save(Department dept) {
		dept.setStatus(1);
		return departmentMapper.save(dept);
	}

	@Override
	public int update(Department dept) {
		return departmentMapper.updateDept(dept);
	}

	@Override
	public int deleteById(Long id) {
		departmentMapper.updateParent(id);
		return departmentMapper.deleteById(id);
	}
}
