package Algs;
import java.util.List;

public class SelectionSort {

	public static List<String> Sort(List<String> l) {
		String temp = "";
		for (int i = 0; i < l.size(); i++) {
			for (int j = i + 1; j < l.size(); j++) {
				if (Integer.parseInt(l.get(i)) > Integer.parseInt(l.get(j))) {
					// swap
					temp = l.get(i);
					l.set(i, l.get(j));
					l.set(j, temp);
				}
			}
		}
		return l;
	}
}