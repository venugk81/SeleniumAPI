package com.filesystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmpDataSortByIDUsingComparable {
	
	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<Employee>();
		emps.add(new Employee(10, "venu"));
		emps.add(new Employee(20, "kris"));
		emps.add(new Employee(2, "sri"));
		emps.add(new Employee(15, "gopi"));
		
		System.out.println("Before sorting: \n"+ emps);
		Collections.sort(emps);
		System.out.println("After sorting: \n"+ emps);
	}

}
