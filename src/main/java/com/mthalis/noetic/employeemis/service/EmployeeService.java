package com.mthalis.noetic.employeemis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthalis.noetic.employeemis.dto.EmployeeDto;
import com.mthalis.noetic.employeemis.exception.EmployeeNotFoundException;
import com.mthalis.noetic.employeemis.model.Employee;
import com.mthalis.noetic.employeemis.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	public EmployeeDto getEmployeeById(String employeeId) {
		Employee employee = employeeRepository.findOne(employeeId);
		if(employee == null) {
			throw new EmployeeNotFoundException("Employee ID Not Found : " + employeeId);
		}
		return new EmployeeDto(employee.getEmployeeID(), employee.getFirstname(),
				employee.getLastname());
	}
	
    public String addEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee(employeeDto.getEmployeeID(), employeeDto.getFirstname(),
				employeeDto.getLastname());
		return employeeRepository.save(employee).getEmployeeID();
	}

	public void deleteEmployee(String employeeId) throws EmployeeNotFoundException {
		employeeRepository.delete(employeeId);
	}

}
