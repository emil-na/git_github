package Algs;

import java.util.List;

public class MergeSort {
	private static int call;
	private static int temp;

	public static List<String> sort(List<String> l) {
		// btmUp_print(l, 2);
		btmUp(l, 2); // pass smallest sub array size(2) for recursion
		return l;
	}

	private static void btmUp(List<String> l, int sub) {
		int parts = l.size() / sub;
		int last = l.size() % sub;
		if (last != 0)
			parts += 1;
		System.out.println("size: " + l.size() + ", sub: " + sub + ", parts: " + parts + ", last: " + last);
		if (sub == 2) { // sort sub arrays size(2)
			int start, end;
			start = 0;
			end = sub - 1; // 1
			sub_sort_recursive(l, start, end, sub);
		}
		if (sub > 2) { // merge larger arrays
			sub_merge_recursive(l, 0, 0, sub, parts, last);
		}
		if (sub * 2 < l.size())
			btmUp(l, sub * 2); // keep recursion call at the end
	}

	private static void sub_merge_recursive(List<String> l, int start, int start2, int sub, int parts, int last) {
		if (parts == 2) { // no recursion
			sub_merge(l, 0, sub, l.size() - 1);
		} else {
			// conditions to call a recursion
			
		}
	}

	private static void sub_merge(List<String> l, int start, int start2, int end) {
		System.out.println("start: " + start + ", start2: " + start2 + ", end: " + end);
		// parallel loop to compare/swap sub1 & sub2 values
	}

	private static void sub_sort_recursive(List<String> l, int start, int end, int sub) {
		sub_sort(l, start, end);
		if (end != l.size() - 1) {
			start += sub;
			if (end + sub < l.size())
				end += sub;
			else
				end = l.size() - 1;
			sub_sort_recursive(l, start, end, sub);
		}
	}

	private static void sub_sort_iterative(List<String> l, int start, int end) {
		sub_sort(l, start, end);
	}

	private static void sub_sort(List<String> l, int start, int end) {
		if (end - start == 1) { // sort only sub arrays size(2)
			if (Integer.parseInt(l.get(start)) > Integer.parseInt(l.get(end))) {
				temp = Integer.parseInt(l.get(start));
				l.set(start, l.get(end));
				l.set(end, temp + "");
			}
		}
	}

	private static void btmUp_print(List<String> l, int sub) {
		++call;
		int start = 0, end;
		for (int i = 0; i < l.size(); i++) { // arrays size 2
			start = i;
			if (i + sub < l.size())
				end = i + sub - 1;
			else {
				end = l.size() - 1;
			}
			print(i, start, end);
			sub_sort_iterative(l, start, end);
			i += sub - 1;
		}
		if (sub * 2 < l.size() / 2 + 1)
			btmUp_print(l, sub * 2); // sub arrays > size 2 & < half array
		else if (sub * 2 < l.size()) {
			call++; // sub arrays ~= half array
			start = 0;
			end = sub * 2 - 1;
			print(0, start, end);
			start = end + 1;
			end = l.size() - 1;
			print(0, start, end);
			call++; // whole array computed for print
			print(0, 0, l.size() - 1);
		}
	}

	private static void print(int i, int start, int end) {
		if (true)
			// System.out.println(call + ": " + i + ". start: " + start + ", end: " + end);
			System.out.println(call + ", start: " + start + ", end: " + end);
	}
}