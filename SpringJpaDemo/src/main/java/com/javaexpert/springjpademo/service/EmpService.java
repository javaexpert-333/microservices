package com.javaexpert.springjpademo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.javaexpert.springjpademo.entity.Employee;
import com.javaexpert.springjpademo.repository.EmpRepo;

@Service
public class EmpService {

	@Autowired
	EmpRepo empRepo;
	
	public Employee saveEmpData(Employee emp) {
		return empRepo.save(emp);
	}
	
	public Employee getById(Integer empId) {
		return empRepo.findById(empId).get();
	}
	
	public List<Employee> getAllEmp(int pageNo, int recordCount) {
		Pageable pageable = PageRequest.of(pageNo, recordCount, Sort.by("empName"));
		return empRepo.findAll(pageable).get().toList();
	}
	
	public List<Employee> getByEmpName(String empName,int pageNo, int recordCount) {
		Pageable pageable = PageRequest.of(pageNo, recordCount, Sort.by("empAge"));
		return empRepo.getByEmpName(empName,pageable);
	}
}
