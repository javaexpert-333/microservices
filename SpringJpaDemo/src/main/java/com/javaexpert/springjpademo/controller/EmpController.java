package com.javaexpert.springjpademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpert.springjpademo.entity.Employee;
import com.javaexpert.springjpademo.service.EmpService;

@RestController
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	@PostMapping("/save")
	public Employee saveEmpData(@RequestBody Employee emp) {
		return empService.saveEmpData(emp);
	}
	
	@GetMapping("/get/{empId}")
	public Employee getById(@PathVariable Integer empId) {
		return empService.getById(empId);
	}
	
	@GetMapping("/getAllEmp/{pageNo}/{recordCount}")
	public List<Employee> getAllEmp(@PathVariable int pageNo, @PathVariable int recordCount) {
		return empService.getAllEmp(pageNo, recordCount);
	}
	@GetMapping("/getByEmpName/{empName}/{pageNo}/{recordCount}")
	public List<Employee> getByEmpName(@PathVariable String empName, @PathVariable int pageNo, @PathVariable int recordCount) {
		return empService.getByEmpName(empName,pageNo, recordCount);
	}
	
}
