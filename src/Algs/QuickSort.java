package Algs;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

	public static List<String> sort(List<String> l) {
		if (l.size() < 3) {
			System.out.println("array size must be >= 3");
			return l;
		}
		boolean swap = false;
		int mid = pivot(l);
		System.out.println("mid: " + l.get(mid));
		int lo = 0, hi = l.size() - 1;
		while (lo != mid && hi != mid) {
			lo = scan_lo(l, mid, lo);
			//System.out.println("scan lo: " + l.get(lo));
			hi = scan_hi(l, mid, hi);
			//System.out.println("scan hi: " + l.get(hi));
			if (lo != mid && hi != mid) {
				swap = swap(l, lo, hi);
			}
		}
		// _LoadData.Print("interim > ", l);
		if (swap) { // recursion
			sort(l);
		}
		return l;
	}

	private static int pivot(List<String> l) {
		// int mid = ThreadLocalRandom.current().nextInt(1, l.size() - 1);
		int mid = l.size() / 2, lo = 0, hi = l.size() - 1;
		if (Integer.parseInt(l.get(hi)) < Integer.parseInt(l.get(lo))) {
			swap(l, lo, hi);
		}
		if (Integer.parseInt(l.get(mid)) < Integer.parseInt(l.get(lo))) {
			swap(l, mid, lo);
		}
		if (Integer.parseInt(l.get(mid)) > Integer.parseInt(l.get(hi))) {
			swap(l, mid, hi);
		}
		return mid;
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
		System.out.println("SWAP > lo: " + l.get(lo) + ", hi: " + l.get(hi));
		String temp = l.get(hi);
		l.set(hi, l.get(lo));
		l.set(lo, temp);
		return true;
	}
}