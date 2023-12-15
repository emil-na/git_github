package Algs;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

	public static List<String> sort(List<String> l) {
		if (l.size() < 3) {
			// System.out.println("array size must be >= 3");
			// return l;
		}
		return quickSort(l, 0, l.size());
	}

	private static List<String> quickSort(List<String> l, int s, int e) {
		int p = pivot(l, s, e);
		print_sub("pivot: " + l.get(p) + " > ", l, s, e);
		int i = s - 1, j = s;
		while (j < e) {
			_LoadData.count++;
			// if j > p: j++
			if (Integer.parseInt(l.get(j)) > Integer.parseInt(l.get(p))) {
				j++;
			}
			// if j < p: i++, swap i & j val
			if (Integer.parseInt(l.get(j)) < Integer.parseInt(l.get(p))) {
				swap(l, ++i, j);
			}
			// when j reach p: i++, swap i & p val
			if (j == p) {
				swap(l, ++i, p);
				System.out.println("pivot: " + l.get(p) + ", swap: " + l.get(i) + ", " + l.get(p));
			}
			j++;
		}
		print_sub("pivot: " + l.get(p) + " > ", l, s, e);
		// recursion call
		int m = (e + s) / 2;
		if (m > 0 && m != s) {
			// System.out.println("s, m, e: " + s + ", " + m + ", " + e);
			// quickSort(l, s, m);
			// quickSort(l, m, e);
		}
		return l;
	}

	private static int pivot(List<String> l, int s, int e) { // median of three
		int p1 = s;
		int p2 = (e + s) / 2;
		int p3 = e - 1;
		if (Integer.parseInt(l.get(p1)) > Integer.parseInt(l.get(p2)))
			swap(l, p1, p2);
		if (Integer.parseInt(l.get(p2)) < Integer.parseInt(l.get(p3)))
			swap(l, p2, p3);
		if (Integer.parseInt(l.get(p1)) > Integer.parseInt(l.get(p3)))
			swap(l, p1, p3);
		return p3;
	}

	private static boolean swap(List<String> l, int lo, int hi) {
		// System.out.println("SWAP > lo: " + l.get(lo) + ", hi: " + l.get(hi));
		String temp = l.get(hi);
		l.set(hi, l.get(lo));
		l.set(lo, temp);
		return true;
	}

	private static void print_sub(String msg, List<String> l, int s, int е) {
		String out = msg;
		for (int i = s; i < е; i++) {
			out += l.get(i) + ", ";
		}
		System.out.println(out);
	}
}