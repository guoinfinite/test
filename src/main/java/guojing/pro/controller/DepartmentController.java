package guojing.pro.controller;

import guojing.pro.entity.Department;
import guojing.pro.services.DepartmentServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guojing
 * @version 1.0
 * @date 2020/9/24 下午2:40
 */
@RestController
@RequestMapping("/dept")
public class DepartmentController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DepartmentServices departmentServices;

	@GetMapping("/get/{id}")
	public Map<String, Object> getDept(@PathVariable("id") Long id) {
		Map<String, Object> map = new HashMap<>();
		Department department = null;
		department = departmentServices.getDept(id);
		map.put("data", department);
		if (department != null) {
			map.put("msg", "查询成功");
			map.put("code", 1);
		} else {
			map.put("msg", "未找到该部门");
			map.put("code", 0);
		}
		return map;
	}

	@GetMapping("/gets")
	public Map<String, Object> getAllDept() {
		Map<String, Object> map = new HashMap<>();
		List<Department> list = null;
		try {
			list = departmentServices.getAllDept();
			map.put("data", list);
			map.put("msg", "查询成功");
			map.put("code", 1);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "查询失败");
			map.put("code", 0);
		}
		return map;
	}

	@PostMapping("/save")
	public Map<String, Object> save(@Valid @RequestBody Department department, BindingResult bindingResult) {
		logger.info("department = " + department);
		Map<String, Object> map = new HashMap<>();
		Department dept = null;
		if (null != department.getPid()) {
			dept = departmentServices.getDept(department.getPid());
		}
		/*判断传来的pid父部门是否存在*/
		if (dept == null) {
			map.put("code", 0);
			map.put("msg", "父部门不存在，请重试");
		} else {
			boolean errors = bindingResult.hasErrors();
			if (errors) {
				List<FieldError> errors1 = bindingResult.getFieldErrors();
				for (FieldError error : errors1) {
					logger.info("错误消息提示：" + error.getDefaultMessage());
					logger.info("错误的字段是？" + error.getField());
					map.put(error.getField(), error.getDefaultMessage());
				}
			} else {
				try {
					Department parent = new Department();
					parent.setId(department.getPid());
					departmentServices.save(department);
					map.put("code", 1);
					map.put("msg", "保存成功");
				} catch (Exception e) {
					logger.info(e.getMessage());
					map.put("code", 0);
					map.put("msg", "保存失败");
				}
			}
		}
		return map;
	}

	@PostMapping("/edit")
	public Map<String, Object> update(@Valid @RequestBody Department department, BindingResult bindingResult) {
		logger.info("department = " + department);
		Map<String, Object> map = new HashMap<>();
		Department dept = null;
		if (null != department.getPid()) {
			dept = departmentServices.getDept(department.getPid());
		}
		/*判断传来的pid父部门是否存在*/
		if (dept == null) {
			map.put("code", 0);
			map.put("msg", "父部门不存在，请重试");
		} else {
			boolean errors = bindingResult.hasErrors();
			if (errors) {
				List<FieldError> errors1 = bindingResult.getFieldErrors();
				for (FieldError error : errors1) {
					logger.info("错误消息提示：" + error.getDefaultMessage());
					logger.info("错误的字段是？" + error.getField());
					map.put(error.getField(), error.getDefaultMessage());
				}
			} else {
				try {
					Department parent = new Department();
					parent.setId(department.getPid());
					departmentServices.update(department);
					map.put("code", 1);
					map.put("msg", "修改成功");
				} catch (Exception e) {
					logger.info(e.getMessage());
					map.put("code", 0);
					map.put("msg", "修改失败");
				}
			}
		}
		return map;
	}

	@GetMapping("/delete/{id}")
	public Map<String, Object> delete(@PathVariable("id") Long id) {
		Map<String, Object> map = new HashMap<>();
		try {
			departmentServices.deleteById(id);
			map.put("msg", "删除成功");
			map.put("code", "1");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "删除失败");
			map.put("code", "0");
		}
		return map;
	}
}
