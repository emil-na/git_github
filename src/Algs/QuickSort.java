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
		// int p = e - 1; // pivot is always the last
		int i = -1, j = 0;
		System.out.println("p: " + l.get(p) + "; s: " + s + "; e: " + e);
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
			}
			j++;
		}
		// recursion call
		if (e - s > 1) {
			quickSort(l, s, s + (e - s) / 2);
			quickSort(l, s + (e - s) / 2, e);
		}
		return l;
	}

	private static int pivot(List<String> l, int s, int e) { // median of three
		int p1 = s;
		int p2 = (e - s) / 2;
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
}