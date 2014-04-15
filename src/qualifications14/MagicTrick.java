package qualifications14;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;

public class MagicTrick {

	public static void main(String[] args) throws IOException {
		String path = "files/q14/magictrick-small.bin";
		List<String> lines = Files.readAllLines(FileSystems.getDefault().getPath(path), Charset.forName("UTF-8"));
		Iterator<String> linesIt = lines.iterator();
		int t = toInt(linesIt.next());
		for (int i = 0; i < t; i++) {
			int ans1 = toInt(linesIt.next());
			int[][] arr1 = toInt(linesIt, 4);
			int ans2 = toInt(linesIt.next());
			int[][] arr2 = toInt(linesIt, 4);
			solve(arr1[ans1 - 1], arr2[ans2 - 1], i + 1);
		}

	}

	private static void solve(int[] arr1, int[] arr2, int c) {
		int matches = 0;
		int number = -1;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					matches++;
					number = arr1[i];
				}
			}
		}
		if (matches == 0) {
			System.out.println("Case #" + c + ": Volunteer cheated!");
		}
		if (matches == 1) {
			System.out.println("Case #" + c + ": " + number);
		}
		if (matches > 1) {
			System.out.println("Case #" + c + ": Bad magician!");
		}
	}

	private static int[][] toInt(Iterator<String> lines, int size) {
		int[][] ints = new int[size][size];
		for (int i = 0; i < size; i++) {
			ints[i] = toInt(lines.next().split(" "));
		}
		return ints;
	}

	private static int toInt(String string) {
		return Integer.parseInt(string);
	}

	private static int[] toInt(String[] strings) {
		int[] ints = new int[strings.length];
		for (int i = 0; i < strings.length; i++) {
			ints[i] = Integer.parseInt(strings[i]);
		}
		return ints;
	}


}
