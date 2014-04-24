package practice;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MinimumScalarProduct {

	public static void main(String[] args) throws IOException {
		String path = "files/practice/MinimumScalarProduct.bin";
		List<String> allLines = Files.readAllLines(FileSystems.getDefault().getPath(path), Charset.forName("UTF-8"));
		Iterator<String> lines = allLines.iterator();
		int testCases = toInt(lines.next());
		for (int i = 1; i <= testCases; i++) {
			lines.next();
			Integer[] x = toInt(lines.next().split(" "));
			Integer[] y = toInt(lines.next().split(" "));
			solve(x, y, i);
		}
	}

	private static void solve(Integer[] x, Integer[] y, int i) {
		Arrays.sort(x);
		Arrays.sort(y, Collections.reverseOrder());
		long result = 0;
		for (int j = 0; j < y.length; j++) {
			result += (x[j] * y[j]);
		}
		System.out.println("Case #" + i + ": " + result);
	}

	private static Integer toInt(String string) {
		return Integer.parseInt(string);
	}

	private static Integer[] toInt(String[] strings) {
		Integer[] ints = new Integer[strings.length];
		for (int i = 0; i < strings.length; i++) {
			ints[i] = Integer.parseInt(strings[i]);
		}
		return ints;
	}

}
