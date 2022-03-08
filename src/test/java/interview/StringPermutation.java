package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

public class StringPermutation {
	List<String> lst = new ArrayList<>();
	List<Integer> nos = new ArrayList<Integer>();

//	@Test
	public void stringPermutation() {
		String srcStr = "abc";
		permutation(srcStr, "");
		System.out.println(lst);
		int min = 1;
		int max = 4;
		System.out.println("Random number generation in Java: (int)(Math.random()*(max-min+1)+min):  \n"
				+ (int) (Math.random() * (max - min + 1) + min));
	}

	public void permutation(String src, String combination) {
		if (src.length() == 0) {
			System.out.println(combination);
			lst.add(combination);
		}
		for (int i = 0; i < src.length(); i++) {
			String left = src.substring(0, i);
			String chr = String.valueOf(src.charAt(i));
			String right = src.substring(i + 1);
			permutation(left + right, combination + chr);
		}
	}

	@Test
	public void RepeatingNumbers() {
		//How many times each no is repeating in an array
		List<Integer> lst = new ArrayList<>(Arrays.asList(3, 54, 1, 1, 4, 3, 6, 54, 3, 7, 8));

		Map<Integer, Integer> map1 = new LinkedHashMap<>();
		int no = 0;
		for (int i = 0; i < lst.size(); i++) {
			no = lst.get(i);
			if (!map1.containsKey(no)) {
				map1.put(no, 1);
			} else {
				int cnt = map1.get(no);
				map1.put(no, cnt + 1);
			}
		}
		System.out.println(map1);
		List<Entry<Integer, Integer>> l1 = new ArrayList<>(map1.entrySet());
		Collections.sort(l1, (o1, o2) -> o1.getValue() - o2.getValue());
		System.out.println(l1);
	}

	@Test
	public void numberRepeatingIndexesFirstTime() {
		List<Integer> lst = new ArrayList<>(Arrays.asList(3, 54, 1, 54, 1, 4, 3, 6, 54, 3, 7, 8));

//		System.out.println(lst.get(lst.size()-1));    size - 1 gives last element.

		Map<Integer, Integer> map1 = new LinkedHashMap<>();
		Map<Integer, Integer> repeatingNos = new LinkedHashMap<>();
		List<Integer> dummy = new ArrayList<>();

		for (int i = 0; i < lst.size(); i++) {
			int no = lst.get(i);
			if (map1.containsKey(no) && !dummy.contains(no)) {
				repeatingNos.put(no, i);
				dummy.add(no);
			} else {
				map1.put(no, 1);
			}
		}
		System.out.println("actusl list: \n" + lst);
		System.out.println("----------Each number of a list are repeating at indexes: ------------------");
		System.out.println(repeatingNos);

		List<Entry<Integer, Integer>> ent = new ArrayList<>(repeatingNos.entrySet());
		Collections.sort(ent, (o1, o2) -> o1.getValue() - o2.getValue());
		System.out.println(ent);

	}

	@Test
	public void print100NoLoops() {
		noRecur(1);
		System.out.println(nos);
	}

	public void noRecur(int no) {
		if (no < 100) {
			nos.add(no);
			no++;
			noRecur(no);
		}
	}

}
