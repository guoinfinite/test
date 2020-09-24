import guojing.pro.entity.Employee;
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

    @Test
    public void test01() {
        Employee employee = employeeServices.getEmployeeById((long) 3);
        System.out.println("employee = " + employee);
    }

}
