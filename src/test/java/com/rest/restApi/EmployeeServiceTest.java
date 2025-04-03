package com.rest.restApi;

import com.rest.restApi.model.Employee;
import com.rest.restApi.repository.EmployeeRepository;
import com.rest.restApi.service.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeService employeeService;

    Employee employee;

    @BeforeEach
    public void createEmployee() {
        employee = Employee.builder()
                .id("123")
                .name("John Doe")
                .gender("Male")
                .age(30)
                .build();
    }

    @Test
    public void getEmployee_withValidId_returnsEmployee(){
        when(employeeRepository.findById(anyString())).thenReturn(Optional.of(employee));
        Employee resultEmployee =employeeService.getEmployee("id");
        verify(employeeRepository).findById("id");
        verify(employeeRepository,times(1)).findById("id");
        assertEquals(resultEmployee,employee);
    }



}
