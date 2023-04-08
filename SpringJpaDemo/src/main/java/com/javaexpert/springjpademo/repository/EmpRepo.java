package com.javaexpert.springjpademo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaexpert.springjpademo.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

	public List<Employee> getByEmpName(String empName, Pageable pageable);
}
