package qualifications14;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;

public class CookieClickerAlpha {

	public static void main(String[] args) throws IOException {
		String path = "files/q14/cookieclicker-large.bin";
		List<String> lines = Files.readAllLines(FileSystems.getDefault().getPath(path), Charset.forName("UTF-8"));
		Iterator<String> linesIt = lines.iterator();
		int t = toInt(linesIt.next());
		for (int i = 0; i < t; i++) {
			double[] input = toDouble(linesIt.next().split(" "));
			double c = input[0];
			double f = input[1];
			double x = input[2];
			solve(c, f, x, i + 1);
		}

	}

	private static void solve(double c, double f, double x, int caseN) {
		double min = Double.MAX_VALUE;
		boolean found = false;
		int farms = 0;
		while (!found) {
			double timeToFarms = 0;
			for (int i = 0; i < farms; i++) {
				double rateForI = 2 + i * f;
				timeToFarms += c / rateForI;
			}
			double rateForFarms = 2 + farms * f;
			double total = (x / rateForFarms) + timeToFarms;
			if (total < min) {
				min = total;
				farms++;
			} else {
				found = true;
				System.out.println(String.format("Case #%d: %.7f", caseN, min));
			}
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

	private static double[] toDouble(String[] strings) {
		double[] floats = new double[strings.length];
		for (int i = 0; i < strings.length; i++) {
			floats[i] = Float.parseFloat(strings[i]);
		}
		return floats;
	}

}
