package guojing.pro.entity;

/**
 * @author guojing
 * @version 1.0
 * @date 2020/9/24 上午9:56
 */
public class Employee {

	private Long id;
	private Integer age;
	private String name;
	private Integer gender;
	private String address;

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

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", age=" + age +
				", name='" + name + '\'' +
				", gender=" + gender +
				", address='" + address + '\'' +
				'}';
	}
}
