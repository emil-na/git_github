package Algs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort2 {
	private static int call;
	private static List<String> l1 = new ArrayList<String>();

	public static List<String> sort(List<String> l) {
		l1.addAll(l); // need the same size array
		partition(l, 0);
		return l1;
	}

	private static void partition(List<String> l, int start) {
		int part = 1, parts, last;
		int s1 = start, s2 = s1 + part;
		int sz1, sz2;
		// call mergeSort() with two consecutive sub arrays
		while (part < l.size()) {
			parts = l.size() / part;
			last = l.size() % part;
			System.out.println("size: " + l.size() + ", parts: " + parts + ", part: " + part + ", last: " + last);
			for (int i = 0; i < parts / 2; i++) {
				s1 = part * i * 2;
				s2 = s1 + part;
				sz1 = sz2 = part;
				mergeSort(l, s1, sz1, s2, sz2);
				print_sub(l1, s1, sz1, s2, sz2);
			}
			//l = l1;
			if (last > 0 && parts == 1) {
				s1 = 0;
				s2 = s1 + part;
				sz1 = part;
				sz2 = last;
				mergeSort(l, s1, sz1, s2, sz2);
				print_sub(l, s1, sz1, s2, sz2);
			}
			l = l1;
			part *= 2;
		}
	}

	private static void mergeSort(List<String> l, int s1, int sz1, int s2, int sz2) {
		int i = s1, j = s2, k = s1; // double traverse loop
		while (i < s1 + sz1 && j < s2 + sz2) {
			if (Integer.parseInt(l.get(i)) < Integer.parseInt(l.get(j))) {
				// System.out.println("k: " + k + ", " + l.get(i) + " < " + l.get(j));
				l1.set(k++, l.get(i++));
			} else {
				// System.out.println("k: " + k + ", " + l.get(i) + " > " + l.get(j));
				l1.set(k++, l.get(j++));
			}
		}
		while (i < s1 + sz1) {
			l1.set(k++, l.get(i++));
		}
		while (j < s2 + sz2) {
			l1.set(k++, l.get(j++));
		}
	}

	private static void print_sub(List<String> l, int s1, int sz1, int s2, int sz2) {
		String out = "sub: (";
		for (int i = s1; i < s1 + sz1; i++) {
			out += l.get(i) + ", ";
		}
		out = out.substring(0, out.length() - 2) + "), (";
		for (int i = s2; i < s2 + sz2; i++) {
			out += l.get(i) + ", ";
		}
		System.out.println(out.substring(0, out.length() - 2) + ")");
	}
}