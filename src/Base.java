import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Base {

	public static void main(String[] args) throws IOException {
		String path = "";
		List<String> allLines = Files.readAllLines(FileSystems.getDefault().getPath(path), Charset.forName("UTF-8"));
		Iterator<String> lines = allLines.iterator();
		int testCases = toInt(lines.next());
		for (int testCase = 1; testCase <= testCases; testCase++) {

		}
	}

	private static void answer(int testCase, Object ans) {
		System.out.println("Case #" + testCase + ": " + ans);
	}

	private static void print(Object[][] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.println(Arrays.toString(data[i]));
		}
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

	private static Double[] toDouble(String[] strings) {
		Double[] floats = new Double[strings.length];
		for (int i = 0; i < strings.length; i++) {
			floats[i] = Double.parseDouble(strings[i]);
		}
		return floats;
	}
}
