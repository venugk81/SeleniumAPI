package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;


//Minimum difference between 2 elements of an array
public class FirstQuestion {

	@Test
	public void leastDifferenceOfElements() {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);		
		list.add(60); 		
		list.add(30); 		
		list.add(1); 		
		list.add(5); 		
		list.add(65);		
		list.add(63);	
		Collections.sort(list);
		
		System.out.println("Sorted List: "+ list);
		//Sorted List: [1, 5, 10, 30, 60, 65]
				
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);	
		
		//remove duplicates 		
		List<Integer> noDups = new ArrayList<Integer>();
		for(int i=0; i< list.size(); i++) {
			if(!noDups.contains(list.get(i))) {
				noDups.add(list.get(i));
			}
		}		
		System.out.println("Array List with no duplicates: "+ noDups);		
		int diff = Integer.MAX_VALUE;
		int ele1=0;
		int ele2 =0;		
		
		for(int i=0; i< noDups.size(); i++) {
			for(int j=i+1; j<noDups.size(); j++) {
				if((noDups.get(j) - noDups.get(i)) < diff) {
					diff = noDups.get(j) - noDups.get(i);
					ele1 = noDups.get(j);
					ele2 = noDups.get(i);
				}
			}
		}		
		System.out.println("Num1: "+ ele1 + " num2: "+ ele2 + " and min diff is between 2 elements: "+ diff);		
	}	
}

/* 	Output

Sorted List: [1, 5, 10, 30, 60, 63, 65]
2147483647
-2147483648
Array List with no duplicates: [1, 5, 10, 30, 60, 63, 65]
Num1: 65 num2: 63 and min diff is between 2 elements: 2

*/