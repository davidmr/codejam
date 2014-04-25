package practice;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AllYourBase {

	public static void main(String[] args) throws IOException {
		String path = "files/practice/AllYourBase-large.bin";
		List<String> allLines = Files.readAllLines(FileSystems.getDefault().getPath(path), Charset.forName("UTF-8"));
		Iterator<String> lines = allLines.iterator();
		int testCases = toInt(lines.next());
		for (int testCase = 1; testCase <= testCases; testCase++) {
			String code = lines.next();
			solve(code, testCase);
		}
	}

	private static void solve(String code, int testCase) {
		Map<String, Integer> codification = bestCodification(code);
		BigInteger number = calculate(code, codification);
		answer(testCase, number);
	}

	private static Map<String, Integer> bestCodification(String code) {
		Map<String, Integer> codification = new HashMap<>();
		// initialize with 1 at the left most position
		codification.put(Character.toString(code.charAt(0)), 1);
		int simbolNumber = 0;
		for (int i = 1; i < code.length(); i++) {
			String simbol = Character.toString(code.charAt(i));
			if (!codification.containsKey(simbol)) {
				while (codification.values().contains(simbolNumber)) {
					simbolNumber++;
				}
				codification.put(simbol, simbolNumber);
			}
		}
		return codification;
	}

	private static BigInteger calculate(String code, Map<String, Integer> codification) {
		int n = Math.max(codification.keySet().size(), 2);
		int l = code.length();
		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < code.length(); i++) {
			String simbol = Character.toString(code.charAt(i));
			BigInteger simbolNumber = new BigInteger(String.valueOf(codification.get(simbol)));
			BigInteger nBig = new BigInteger(String.valueOf(n));
			BigInteger r = nBig.pow(l - (i + 1));
			sum = sum.add(r.multiply(simbolNumber));
		}
		return sum;
	}

	private static void answer(int testCase, Object ans) {
		System.out.println("Case #" + testCase + ": " + ans);
	}

	private static Integer toInt(String string) {
		return Integer.parseInt(string);
	}

}
