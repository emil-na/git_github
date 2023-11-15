// Java program to illustrate reading data from file
package Algs;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.Math;

public class _LoadData {
	// public static int digits = 5;
	public static int count;

	public static void main(String[] args) {
		count = 0;
		int n = 7;
		// List<String> l = readFileInList("E:\\JAVA\\test_data\\data_gen-40.csv");
		List<String> l = randomList(n, -500, 1200);
		Print("input > ", l);// print input
		// l = SelectionSort.sort(l);
		// l = InsertionSort.sort(l);
		// l = ShellSort.sort(l);
		// l = Heap.minHeap_build(l);
		// Stats("build heap", n);
		// l = Heap.sortHeap_desc(l);
		// Print("sorted > ", l);// print output
		// Heap.printHeap(l);
		// Stats("sort heap", n);
		MergeSort.sort(l);
	}

	public static void Stats(String msg, int n) {
		String out = msg + " > count: " + count + "; ";
		double log_n = (Math.log(n) / Math.log(2));
		log_n = Math.round(log_n * 1000);
		log_n /= 1000;
		double nlog_n = n * log_n;
		int nsum_n_1 = n * (n + 1) / 2;
		int n2 = n * n;
		int n3 = n * n * n;
		out += "n = " + n + "; ";
		out += "log(n) = " + log_n + "; ";
		out += "n*log(n) = " + (int) nlog_n + "; ";
		out += "n^2/~2 = " + nsum_n_1 + "; ";
		out += "n^2 = " + n2 + "; ";
		out += "n^3 = " + n3;
		System.out.println(out);
		count = 0;
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