package Algs;

import java.util.List;

public class Heap {
	private static int n, p, lc, rc; // size, parent, left & right node
	private static int temp; // swapping

	public static List<String> maxHeap_build(List<String> l) {
		n = l.size();
		for (int i = (n / 2) - 1; i > -1; i--) {
			maxHeap(l, n, i);
		}
		return l;
	}

	private static void max(List<String> l, int n) {
		// bottom - up
		for (int i = (n / 2) - 1; i > -1; i--) {
			maxHeap(l, n, i);
		}
	}

	public static List<String> sortHeap_asc(List<String> l) {
		n = l.size();
		for (int i = n - 1; i >= 0; i--) {
			temp = Integer.valueOf(l.get(i));
			l.set(i, l.get(0));
			l.set(0, temp + "");
			// restore heap property of the remaining heap - length(n-i)
			max(l, --n);
		}
		return l;
	}

	public static List<String> minHeap_build(List<String> l) {
		n = l.size();
		for (int i = (n / 2) - 1; i > -1; i--) {
			minHeap(l, n, i);
		}
		return l;
	}

	private static void min(List<String> l, int n) {
		for (int i = (n / 2) - 1; i > -1; i--) {
			minHeap(l, n, i);
		}
	}

	public static List<String> sortHeap_desc(List<String> l) {
		n = l.size();
		for (int i = n - 1; i >= 0; i--) {
			if (true) { // testing
				temp = Integer.valueOf(l.get(i));
				l.set(i, l.get(0));
				l.set(0, temp + "");
				// restore heap property of the remaining heap - length(n-i)
				min(l, --n);
			}
		}
		return l;
	}

	private static void minHeap(List<String> l, int n, int i) {
		_LoadData.count++; // sift up
		p = i;
		lc = 2 * i + 1;
		rc = 2 * i + 2;
		// if the index of lc/rc is < n (array index out of bond) && child > parent
		if (lc < n && Integer.valueOf(l.get(lc)) < Integer.valueOf(l.get(p))) {
			p = lc;
		}
		if (rc < n && Integer.valueOf(l.get(rc)) < Integer.valueOf(l.get(p))) {
			p = rc;
		}
		if (p != i) {
			temp = Integer.valueOf(l.get(p));
			l.set(p, l.get(i));
			l.set(i, temp + "");
			maxHeap(l, n, p);
		}
	}

	private static void maxHeap(List<String> l, int n, int i) {
		_LoadData.count++; // sift up
		p = i;
		lc = 2 * i + 1;
		rc = 2 * i + 2;
		// if the index of lc/rc is < n (array index out of bond) && child > parent
		if (lc < n && Integer.valueOf(l.get(lc)) > Integer.valueOf(l.get(p))) {
			p = lc;
		}
		if (rc < n && Integer.valueOf(l.get(rc)) > Integer.valueOf(l.get(p))) {
			p = rc;
		}
		if (p != i) {
			temp = Integer.valueOf(l.get(p));
			l.set(p, l.get(i));
			l.set(i, temp + "");
			maxHeap(l, n, p);
		}
	}

	public static void printHeap(List<String> l) {
		int size = l.size();
		int depth = (int) (Math.log10(size) / Math.log10(2));
		// System.out.println(depth + ", " + width + ", " + le);
		int k = 0;
		String val;
		for (int i = 0; i < depth + 1; i++) {
			int width = (int) Math.pow(2, i);
			String temp = i + "(" + width + "): ";
			for (int j = 0; j < width; j++) {
				if (k < l.size()) {
					val = l.get(k);
					if (val.length() < 4) {
						val = " ".repeat(4 - val.length()) + val;
						// System.out.println(val);
					}
					// System.out.println(depth);
					temp += " ".repeat((int) Math.pow(2, depth - i) + (depth - i) * depth) + val + ", ";
				}
				k++;
			}
			System.out.println(temp);
		}
	}
}
