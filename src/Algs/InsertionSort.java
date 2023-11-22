package Algs;

import java.util.List;

public class InsertionSort {
	public static List<String> sort(List<String> l) {
		System.out.println("InsertionSort:"); // n*(n+1)/2, 1+2+3+..n
		String temp = "";
		for (int i = 1; i < l.size(); i++) {
			_LoadData.count++;
			for (int j = 0; j < i; j++) {
				_LoadData.count++;
				//System.out.println("i: " + i + "; j: " + j);
				if (Integer.parseInt(l.get(i)) < Integer.parseInt(l.get(j))) {
					// _LoadData.count++;
					// swap
					// System.out.println("i: " + i + "; j: " + j);
					temp = l.get(i);
					l.set(i, l.get(j));
					l.set(j, temp);
					// _LoadData.Print("swap > ", l);
				}
			}
		}
		return l;
	}
}