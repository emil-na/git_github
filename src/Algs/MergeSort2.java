package Algs;

import java.util.ArrayList;
import java.util.List;
import java.math.*;

public class MergeSort2 {
	private static int call;
	private static List<String> l1 = new ArrayList<String>();

	public static List<String> sort(List<String> l) {
		l1.addAll(l);
		parts1(l);
		// parts1(l);
		return l1;
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
			if (last % 2 != 0 && last > 1) { // sort odd size partitions
				s1 = l.size() - last;
				sz1 = last - last % 2;
				s2 = l.size() - last % 2;
				sz2 = last % 2;
				// System.out.println(s1 + ", " + sz1 + ", " + s2 + ", " + sz2);
				print_sub("last: ", l, s1, sz1, s2, sz2);
				mergeSort(l, s1, sz1, s2, sz2);
			}
			if (parts == 1) { // largest part + remainder
				s1 = 0;
				sz1 = part;
				s2 = l.size() - last;
				// print_sub("last: ", l, s1, sz1, s2, last);
				mergeSort(l, s1, sz1, s2, last);
			}
			// l = l1; // both variables point to the same object !!! 3 days bug !!!
			// l.clear(); // empty and replace the values with the processed ones
			// l.addAll(l1);
			part *= 2;
		}
	}

	private static void mergeSort(List<String> l, int s1, int sz1, int s2, int sz2) {
		_LoadData.count++;
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
		l.clear(); // empty and replace the values with the processed ones
		l.addAll(l1);
	}

	private static void print_sub(String msg, List<String> l, int s1, int sz1, int s2, int sz2) {
		String out = msg + "(";
		for (int i = s1; i < s1 + sz1; i++) {
			out += l.get(i) + ", ";
		}
		System.out.println(out);
		out = out.substring(0, out.length() - 2) + "), (";
		for (int i = s2; i < s2 + sz2; i++) {
			out += l.get(i) + ", ";
		}
		System.out.println(out.substring(0, out.length() - 2) + ")");
	}
}