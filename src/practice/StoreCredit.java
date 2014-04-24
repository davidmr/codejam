package practice;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;

public class StoreCredit {

	public static void main(String[] args) throws IOException {
		String path = "files/practice/StoreCredit-small-practice.bin";
		List<String> lines = Files.readAllLines(FileSystems.getDefault().getPath(path), Charset.forName("UTF-8"));
		int n = Integer.parseInt(lines.get(0));
		int linesPerCase = 3;
		for (int i = 0; i < n; i++) {
			int offset = (i * linesPerCase) + 1;
			int c = Integer.parseInt(lines.get(offset));
			int[] p = stringToInt(lines.get(offset + 2).split(" "));
			solve(i, c, p);
		}

	}

	private static void solve(int caseN, int c, int[] p) {
		for (int i = 0; i < p.length; i++) {
			for (int j = i + 1; j < p.length; j++) {
				if (p[i] + p[j] == c) {
					System.out.println(String.format("Case #%d: %d %d", caseN + 1, i + 1, j + 1));
				}
			}
		}
	}

	private static int[] stringToInt(String[] strings) {
		int[] ints = new int[strings.length];
		for (int i = 0; i < strings.length; i++) {
			ints[i] = Integer.parseInt(strings[i]);
		}
		return ints;
	}

}
