package Algs;
import java.util.List;

public class SelectionSort {

	public static List<String> sort(List<String> l) {
		System.out.println("SelectionSort:");
		String temp = "";
		for (int i = 0; i < l.size(); i++) {
			_LoadData.count++;
			for (int j = i + 1; j < l.size(); j++) {
				_LoadData.count++;
				if (Integer.parseInt(l.get(i)) > Integer.parseInt(l.get(j))) {
					//_LoadData.count++;
					// swap
					temp = l.get(i);
					l.set(i, l.get(j));
					l.set(j, temp);
					//_LoadData.Print("swap  > ", l);
				}
			}
		}
		return l;
	}
}