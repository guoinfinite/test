package guojing.pro.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author guojing
 * @version 1.0
 * @date 2020/9/24 上午9:56
 */
public class Employee {

	private Long id;

	@Min(value = 0, message = "年龄必须大于0岁")
	@Max(value = 100, message = "年龄必须小于100岁")
	private Integer age;
	@NotEmpty(message = "姓名不能为空")
	@Length(min = 5, max = 17, message = "姓名长度为5到17位")
	private String name;
	@Min(value = 0, message = "性别有误")
	@Max(value = 1, message = "性别有误")
	private Integer gender;
	@NotEmpty(message = "地址不能为空")
	private String address;

	private Integer status = 1;

	private Department dept;

	public Employee() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", age=" + age +
				", name='" + name + '\'' +
				", gender=" + gender +
				", address='" + address + '\'' +
				", status=" + status +
				", dept=" + dept +
				'}';
	}
}
