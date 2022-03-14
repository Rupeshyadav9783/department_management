//package com.example.employee;
//
//import com.example.employee.entity.Employee;
//import com.example.employee.repository.EmployeeRepository;
//import com.example.employee.service.EmployeeService;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class EmployeeApplicationTests {
//	@Autowired
//	private EmployeeService service;
//
//	@MockBean
//	private EmployeeRepository repository;
//
//	@Test
//	public void getEmployeesTest(){
//		when(repository.findAll()).thenReturn(Stream.of(new Employee(12,"Ashok",11,null)).collect(Collectors.toList()));
//		assertEquals(1,service.getEmployees().size());
//	}
//
//	@Test
//	public void saveEmployeeTest(){
//		Employee employee = new Employee(6,"Rohan",34,null);
//		when(repository.save(employee)).thenReturn(employee);
//		assertEquals(employee,service.saveEmployee(employee));
//	}
//
//	@Test
//	public void deleteEmployeeTest(){
//		Employee employee = new Employee(6,"Rohan",34,null);
//		service.deleteEmployee(employee.getId());
//		verify(repository,times(1)).delete(employee);
//	}
//}
