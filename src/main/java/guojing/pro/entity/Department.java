package guojing.pro.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author guojing
 * @version 1.0
 * @date 2020/9/24 上午11:31
 */
public class Department {

	private Long id;

	@NotEmpty(message = "部门名称不可以为空")
	@Length(max = 15, min = 2, message = "部门名称长度需要在2-15个字之间")
	private String name;

	private Department parent;
	private Long pid;

	private String desc;

	private Integer status = 1;

	public Department() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "Department{" +
				"id=" + id +
				", name='" + name + '\'' +
				", parent=" + parent +
				", pid=" + pid +
				", desc='" + desc + '\'' +
				", status=" + status +
				'}';
	}
}
