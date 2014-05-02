package practice;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;

public class WelcomeToCodeJam {

	public static void main(String[] args) throws IOException {
		String path = "files/practice/welcometocodejam-large.bin";
		List<String> allLines = Files.readAllLines(FileSystems.getDefault().getPath(path), Charset.forName("UTF-8"));
		Iterator<String> lines = allLines.iterator();
		int testCases = toInt(lines.next());
		for (int testCase = 1; testCase <= testCases; testCase++) {
			solve("welcome to code jam", lines.next(), testCase);
		}
	}

	private static void solve(String s, String input, int testCase) {
		BigInteger[][] x = new BigInteger[s.length()][input.length()];
		fill(x, new BigInteger("0"));
		// init row 0
		for (int i = 0; i < input.length(); i++) {
			if (s.charAt(0) == input.charAt(i)) {
				if (i == 0) {
					x[0][i] = new BigInteger("1");
				} else {
					x[0][i] = x[0][i - 1].add(new BigInteger("1"));
				}
			} else {
				if (i > 0) {
					x[0][i] = x[0][i - 1];
				}
			}
		}
		for (int i = 1; i < s.length(); i++) {
			for (int j = 0; j < input.length() - 1; j++) {
				if (s.charAt(i) == input.charAt(j + 1)) {
					x[i][j + 1] = x[i][j].add(x[i - 1][j]);
				} else {
					x[i][j + 1] = x[i][j];
				}
			}
		}
		String number = x[s.length() - 1][input.length() - 1].toString();
		int lastFourIndex = Math.max(number.length() - 4, 0);
		String answer = padLeft(number.substring(lastFourIndex), "0", 4);
		answer(testCase, answer);
	}

	private static void answer(int testCase, Object ans) {
		System.out.println("Case #" + testCase + ": " + ans);
	}

	private static String padLeft(String src, String pad, int length) {
		StringBuilder sb = new StringBuilder(src);
		while (sb.length() < length) {
			sb.insert(0, pad);
		}
		return sb.toString();
	}

	private static void fill(Object[][] data, Object obj) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				data[i][j] = obj;
			}
		}
	}

	private static Integer toInt(String string) {
		return Integer.parseInt(string);
	}

}
