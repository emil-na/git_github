package Algs;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

	public static List<String> sort(List<String> l) {
		boolean swap = false;
		int mid = ThreadLocalRandom.current().nextInt(1, l.size() - 1);
		// System.out.println("mid: " + l.get(mid));
		int lo = 0, hi = l.size() - 1;
		while (lo != mid && hi != mid) {
			lo = scan_lo(l, mid, lo);
			hi = scan_hi(l, mid, hi);
			if (lo != mid && hi != mid) {
				swap(l, lo, hi);
			}
		}
		if (swap) { // recursion
			// sort(l);
		}
		return l;
	}

	private static int scan_lo(List<String> l, int mid, int lo) {
		for (int i = lo; i < mid; i++) {
			_LoadData.count++;
			if (Integer.parseInt(l.get(mid)) < Integer.parseInt(l.get(i)))
				return i;
		}
		return mid;
	}

	private static int scan_hi(List<String> l, int mid, int hi) {
		for (int i = hi; i > mid; i--) {
			_LoadData.count++;
			if (Integer.parseInt(l.get(mid)) > Integer.parseInt(l.get(i)))
				return i;
		}
		return mid;
	}

	private static boolean swap(List<String> l, int lo, int hi) {
		System.out.println("lo: " + lo + ", hi: " + hi);
		String temp = l.get(hi);
		l.set(hi, l.get(lo));
		l.set(lo, temp);
		return true;
	}
}