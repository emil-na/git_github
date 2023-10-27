// Java program to illustrate reading data from file
package Algs;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class _LoadData {

	public static void main(String[] args) {
		// List<String> l = readFileInList("E:\\JAVA\\test_data\\data_gen-40.csv");
		List<String> l = randomList(10, -500, 1200);
		Print("input > ", l);// print input
		//l = SelectionSort.Sort(l);// sort
		l = InsertionSort.Sort(l);
		Print("sorted> ", l);// print output
	}

	public static void Print(String txt, List<String> l) {
		Iterator<String> itr = l.iterator();
		StringBuilder out = new StringBuilder();
		out.append(txt);
		while (itr.hasNext()) {
			out = out.append(itr.next() + ", ");
		}
		System.out.println(out.substring(0, out.length() - 2));
	}

	public static List<String> randomList(int size, int min, int max) {
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			// ThreadLocalRandom.current().nextInt(min, max + 1)
			l.add(String.valueOf(ThreadLocalRandom.current().nextInt(min, max + 1)));
		}
		return l;
	}

	public static List<String> readFileInList(String fileName) {

		List<String> lines = Collections.emptyList();
		try {
			lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// do something
			e.printStackTrace();
		}
		// /* remove .csv ';'
		String temp = "";
		for (int i = 0; i < lines.size(); i++) {
			temp = lines.get(i);
			temp = temp.replace(";", "");
			lines.set(i, temp);
		} // */
		return lines;
	}
}