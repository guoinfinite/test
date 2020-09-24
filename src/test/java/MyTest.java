import guojing.pro.entity.Department;
import guojing.pro.entity.Employee;
import guojing.pro.services.DepartmentServices;
import guojing.pro.services.EmployeeServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MyTest {

    @Autowired
    private EmployeeServices employeeServices;

    @Autowired
    private DepartmentServices departmentServices;

    @Test
    public void test01() {
        Employee employee = employeeServices.getEmployeeById((long) 1);
        System.out.println("employee = " + employee);
    }

    @Test
    public void test02() {
        Department department = departmentServices.getDept((long) 2);
        System.out.println("department = " + department);
    }

}
