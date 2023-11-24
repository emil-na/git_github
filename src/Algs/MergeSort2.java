package Algs;

import java.util.ArrayList;
import java.util.List;
import java.math.*;

public class MergeSort2 {
	private static int call;
	private static List<String> l1 = new ArrayList<String>();

	public static List<String> sort(List<String> l) {
		l1.addAll(l);
		parts(l);
		// parts1(l);
		return l1;
	}

	private static void parts(List<String> l) {
		partSort(l, 0, l.size());
	}

	private static void partSort(List<String> l, int start, int size) {
		int max_part = (int) Math.pow(2, ((int) (Math.log(l.size()) / Math.log(2))));
		int remain = l.size() - max_part;
		System.out.println("size: " + l.size() + ", max_part: " + max_part + ", last: " + remain);
		//
		int part = 1, parts, last;
		int s1 = start, s2 = s1 + part;
		int sz1, sz2;
		while (part < size) {
			parts = size / part;
			last = size % part;
			System.out.println("size: " + size + ", parts: " + parts + ", part: " + part + ", last: " + last);
			for (int i = 0; i < parts / 2; i++) {
				s1 = part * i * 2;
				s2 = s1 + part;
				sz1 = sz2 = part;
				mergeSort(l, s1, sz1, s2, sz2);
			}
			if (parts == 1 && last == 1) {
				System.out.println("parts == 1 && last == 1");
				mergeSort(l, 0, part, size - 1, 1);
			}
			// l = l1; // both variables point to the same object !!! 3 days bug !!!
			l.clear(); // empty and replace the values with the processed ones
			l.addAll(l1);
			part *= 2;
		}
		if (remain > 1) {
			//partSort(l,max_part, remain);
		}
	}

	private static void parts1(List<String> l) {
		int start = 0, part = 1, parts, last;
		int s1 = start, s2 = s1 + part;
		int sz1, sz2;
		while (part < l.size()) {
			parts = l.size() / part;
			last = l.size() % part;
			System.out.println("size: " + l.size() + ", parts: " + parts + ", part: " + part + ", last: " + last);
			for (int i = 0; i < parts / 2; i++) {
				s1 = part * i * 2;
				s2 = s1 + part;
				sz1 = sz2 = part;
				mergeSort(l, s1, sz1, s2, sz2);
			}
			// l = l1; // both variables point to the same object !!! 3 days bug !!!
			l.clear(); // empty and replace the values with the processed ones
			l.addAll(l1);
			part *= 2;
		}
	}

	private static void mergeSort(List<String> l, int s1, int sz1, int s2, int sz2) {
		// print_sub("before: ", l, s1, sz1, s2, sz2);
		int i = s1, j = s2, k = s1; // double traverse loop
		while (i < s1 + sz1 && j < s2 + sz2) {
			if (Integer.parseInt(l.get(i)) < Integer.parseInt(l.get(j))) {
				l1.set(k++, l.get(i++));
			} else {
				l1.set(k++, l.get(j++));
			}
		}
		while (i < s1 + sz1) {
			l1.set(k++, l.get(i++));
		}
		while (j < s2 + sz2) {
			l1.set(k++, l.get(j++));
		}
		// print_sub("after: ", l1, s1, sz1, s2, sz2);
	}

	private static void print_sub(String msg, List<String> l, int s1, int sz1, int s2, int sz2) {
		String out = msg + "(";
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