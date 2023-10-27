package Algs;

import java.util.List;

public class InsertionSort {
	public static List<String> Sort(List<String> l) {
		String temp = "";
		for (int i = 1; i < l.size(); i++) {
			for (int j = 0; j < l.size(); j++) {
				// System.out.println("i: " + i + "; j: " + j);
				if (Integer.parseInt(l.get(i)) < Integer.parseInt(l.get(j))) {
					// swap
					System.out.println("i: " + i + "; j: " + j);
					temp = l.get(i);
					l.set(i, l.get(j));
					l.set(j, temp);
					_LoadData.Print("swap  > ", l);
				}
			}
		}
		return l;
	}
}