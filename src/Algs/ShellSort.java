package Algs;

import java.util.List;

public class ShellSort {
	public static List<String> sort(List<String> l) {
		System.out.println("ShellSort:");
		String temp = "";
		for (int i = l.size() / 2; i > 0; i /= 2) {
			_LoadData.count++;
			// System.out.println("i: " + i );
			for (int j = 0; j < l.size() - i; j++) {
				_LoadData.count++;
				if (Integer.parseInt(l.get(j)) > Integer.parseInt(l.get(j + i))) {
					//_LoadData.count++;
					// swap
					temp = l.get(j + i);
					l.set(j + i, l.get(j));
					l.set(j, temp);
					//_LoadData.Print("swap  > ", l);
				}
			}
		}
		return l;
	}
}