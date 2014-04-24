package practice;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;

public class AlienLanguage {

	public static void main(String[] args) throws IOException {
		String path = "files/practice/AlienLanguage-large.bin";
		List<String> allLines = Files.readAllLines(FileSystems.getDefault().getPath(path), Charset.forName("UTF-8"));
		Iterator<String> lines = allLines.iterator();
		Integer[] in = toInt(lines.next().split(" "));
		int d = in[1];
		int testCases = in[2];

		String[] words = new String[d];
		for (int i = 0; i < words.length; i++) {
			words[i] = lines.next();
		}

		for (int i = 1; i <= testCases; i++) {
			String pattern = lines.next();
			solve(words, pattern, i);
		}
	}

	private static void solve(String[] words, String pattern, int i) {
		int count = 0;
		String regExpPattern = pattern.replaceAll("\\(", "[").replaceAll("\\)", "]");
		for (String word : words) {
			if (word.matches(regExpPattern)) {
				count++;
			}
		}
		System.out.println("Case #" + i + ": " + count);
	}

	private static Integer[] toInt(String[] strings) {
		Integer[] ints = new Integer[strings.length];
		for (int i = 0; i < strings.length; i++) {
			ints[i] = Integer.parseInt(strings[i]);
		}
		return ints;
	}

}
