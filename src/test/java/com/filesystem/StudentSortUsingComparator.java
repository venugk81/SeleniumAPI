package com.filesystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentSortUsingComparator {

	
	public static void main(String[] args) {
		List<Student> emps = new ArrayList<Student>();
		emps.add(new Student(10, "venu"));
		emps.add(new Student(20, "kris"));
		emps.add(new Student(2, "sri"));
		emps.add(new Student(15, "gopi"));
		
		System.out.println("Before sorting: \n" + emps);
		
		/*
		Collections.sort(emps, (o1,o2)-> {
			return o1.getId()-o2.getId();
		});
		System.out.println("After sorting------");
		System.out.println(emps);
		
		//OR
		 * 
		 * 				
		Collections.sort(emps, (o1,o2)-> {
			return o1.getName().compareTo(o2.getName());
		});		
		*/		
		Collections.sort(emps, new SortStudentByComparator());		
		System.out.println("After sorting------");
		System.out.println(emps);
	}
}
