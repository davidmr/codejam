package practice;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;

public class RopeIntranet {

	public static void main(String[] args) throws IOException {
		String path = "files/practice/RopeIntranet-large.bin";
		List<String> allLines = Files.readAllLines(FileSystems.getDefault().getPath(path), Charset.forName("UTF-8"));
		Iterator<String> lines = allLines.iterator();
		int testCases = toInt(lines.next());

		for (int i = 1; i <= testCases; i++) {
			int n = toInt(lines.next());
			Integer[][] cables = toInt(lines, n);
			solve(cables, i);
		}
	}

	private static void solve(Integer[][] cables, int testCase) {
		int count = 0;
		for (int i = 0; i < cables.length; i++) {
			for (int j = i; j < cables.length; j++) {
				int a = cables[i][0];
				int b = cables[i][1];
				int x = cables[j][0];
				int y = cables[j][1];
				if (x > a && y < b || x < a && y > b) {
					count++;
				}
			}
		}
		answer(testCase, count);
	}

	private static void answer(int testCase, Object ans) {
		System.out.println("Case #" + testCase + ": " + ans);
	}

	private static Integer[][] toInt(Iterator<String> lines, int size) {
		Integer[][] ints = new Integer[size][size];
		for (int i = 0; i < size; i++) {
			ints[i] = toInt(lines.next().split(" "));
		}
		return ints;
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
