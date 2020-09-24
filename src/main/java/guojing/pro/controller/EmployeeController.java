package guojing.pro.controller;

import guojing.pro.entity.Employee;
import guojing.pro.services.EmployeeServices;
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
 * @date 2020/9/24 上午10:39
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServices employeeServices;

	/**
	 * 根据ID查询员工
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/get/{id}")
	public Map<String, Object> getEmployee(@PathVariable("id") Long id) {
		Map<String, Object> map = new HashMap<>();
		Employee employee = null;
		employee = employeeServices.getEmployeeById(id);
		map.put("data", employee);
		if (employee != null) {
			map.put("msg", "查询成功");
			map.put("code", 1);
		} else {
			map.put("msg", "未找到该员工");
			map.put("code", 0);
		}
		return map;
	}

	/**
	 * 查询所有员工
	 *
	 * @return
	 */
	@GetMapping("/gets")
	public Map<String, Object> getAllEmployee() {
		Map<String, Object> map = new HashMap<>();
		List<Employee> list = employeeServices.getAllEmployee();
		map.put("data", list);
		map.put("msg", "查询成功");
		map.put("code", 1);
		return map;
	}


	@PostMapping("/save")
	public Map<String, Object> save(@Valid @RequestBody Employee employee, BindingResult bindingResult) {
		System.out.println("employee = " + employee);
		Map<String, Object> map = new HashMap<>();
		boolean errors = bindingResult.hasErrors();
		if (errors) {
			List<FieldError> errors1 = bindingResult.getFieldErrors();
			for (FieldError error : errors1) {
				System.out.println("错误消息提示：" + error.getDefaultMessage());
				System.out.println("错误的字段是？" + error.getField());
				System.out.println(errors);
				System.out.println("------------------------");
				map.put(error.getField(), error.getDefaultMessage());
			}
		} else {
			try {
				employeeServices.addEmployee(employee);
				map.put("msg", "添加成功");
				map.put("code", "1");
			} catch (Exception e) {
				e.printStackTrace();
				map.put("msg", "添加失败");
				map.put("code", "0");
			}
		}
		return map;
	}

	@PostMapping("/edit")
	public Map<String, Object> update(@Valid @RequestBody Employee employee, BindingResult bindingResult) {
		System.out.println("employee = " + employee);
		Map<String, Object> map = new HashMap<>();
		boolean errors = bindingResult.hasErrors();
		if (errors) {
			List<FieldError> errors1 = bindingResult.getFieldErrors();
			for (FieldError error : errors1) {
				System.out.println("错误消息提示：" + error.getDefaultMessage());
				System.out.println("错误的字段是？" + error.getField());
				System.out.println(errors);
				System.out.println("------------------------");
				map.put(error.getField(), error.getDefaultMessage());
			}
		} else {
			try {
				employeeServices.updateEmployee(employee);
				map.put("msg", "修改成功");
				map.put("code", "1");
			} catch (Exception e) {
				e.printStackTrace();
				map.put("msg", "修改失败");
				map.put("code", "0");
			}
		}
		return map;
	}
}
