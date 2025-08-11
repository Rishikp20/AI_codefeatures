import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

import java.util.List;

class EmployeeServiceTest {

    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeService();
    }

    @Test
    void testAddEmployee() {
        Employee employee = new Employee(1, "John Doe", "Engineering");
        employeeService.addEmployee(employee);
        assertEquals(employee, employeeService.getEmployeeById(1));
    }

    @Test
    void testGetEmployeeById() {
        Employee employee = new Employee(2, "Jane Smith", "Marketing");
        employeeService.addEmployee(employee);
        assertEquals(employee, employeeService.getEmployeeById(2));
    }

    @Test
    void testUpdateEmployee() {
        Employee employee = new Employee(3, "Alice Johnson", "Sales");
        employeeService.addEmployee(employee);
        employee.setDepartment("HR");
        employeeService.updateEmployee(employee);
        assertEquals("HR", employeeService.getEmployeeById(3).getDepartment());
    }

    @Test
    void testGetAllEmployees() {
        Employee employee1 = new Employee(4, "Bob Brown", "Finance");
        Employee employee2 = new Employee(5, "Charlie Black", "IT");
        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);
        List<Employee> employees = employeeService.getAllEmployees();
        assertEquals(2, employees.size());
    }

    @Test
    void testDeleteEmployee() {
        Employee employee = new Employee(6, "Diana Prince", "Admin");
        employeeService.addEmployee(employee);
        employeeService.deleteEmployee(6);
        assertNull(employeeService.getEmployeeById(6));
    }
}