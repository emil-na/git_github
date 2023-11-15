package Algs;

import java.util.List;

public class MergeSort {
	private static int call;

	public static List<String> sort(List<String> l) {
		btmUp(l, 1);
		return l;
	}

	private static void btmUp(List<String> l, int sub) {
		++call;
		int start = 0, end;
		for (int i = 0; i < l.size(); i++) {
			start = i;
			if (i + sub < l.size()) {
				end = i + sub;
			} else {
				end = l.size() - 1;
			}
			System.out.println(call + ": start: " + start + ", end: " + end);
			i += sub;
		}
		if (sub * 2 < l.size() / 2 + 1) {
			btmUp(l, sub * 2);
		} else {
			call++;
			start = 0;
			end = l.size() / 2;
			System.out.println(call + ": start: " + start + ", end: " + end);
			start = end + 1;
			end = l.size() - 1;
			System.out.println(call + ": start: " + start + ", end: " + end);
			call++;
			start = 0;
			System.out.println(call + ": start: " + start + ", end: " + end);
		}
	}

	private static void sort_sub(List<String> l, int start, int end) {

	}
}